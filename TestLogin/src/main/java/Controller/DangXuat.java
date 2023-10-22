package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@jakarta.servlet.annotation.WebServlet("/DangXuat")
public class DangXuat extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

	public DangXuat() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		session.invalidate();
		response.sendRedirect("DangNhap.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
