package Controller;

import java.io.IOException;

import DAO.KhachHangDAO;
import Model.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/XuLyDangNhap")
public class XuLyDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XuLyDangNhap() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String pass = request.getParameter("pass");
		
		KhachHang kh = new KhachHangDAO().layThongTinTaiKhoan(username);
		System.out.println(kh);
		if(new KhachHangDAO().kiemTraDangNhap(username, pass)){
			HttpSession session = request.getSession();
			session.setAttribute("user", kh);
			
			response.sendRedirect("index.jsp");
		}else{
			System.out.println("Loi dang nhap");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
