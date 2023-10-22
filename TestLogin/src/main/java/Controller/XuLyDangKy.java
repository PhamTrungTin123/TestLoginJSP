package Controller;

import java.io.IOException;

import DAO.KhachHangDAO;
import Model.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/XuLyDangKy")
public class XuLyDangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XuLyDangKy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username= request.getParameter("username");
		String pass= request.getParameter("pass");
		String name= request.getParameter("name");
		
		KhachHang kh = new KhachHang(username, pass, name);
		
		if(new KhachHangDAO().themTaiKhoan(kh)){
//			HttpSession session = request.getSession();
//			session.setAttribute("user", kh);
			response.sendRedirect("DangNhap.jsp");
		}else{
			System.out.println("Lỗi đăng kí");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
