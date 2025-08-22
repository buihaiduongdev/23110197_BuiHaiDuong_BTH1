package w1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/login" })

public class LoginCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.getRequestDispatcher("login.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		// lấy dữ liệu từ tham số của form
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		if (user.equals("cookie") && pass.equals("123")) {
			Cookie cookie = new Cookie("username", user); // khởi tạo cookie
			// thiết lập thời gian tồn tại 30s của cookie
			cookie.setMaxAge(30);
			// thêm cookie vào response
			resp.addCookie(cookie);
			// chuyển sang trang HelloServlet
			resp.sendRedirect(req.getContextPath() + "/hello");
		} else {
			// chuyển sang trang LoginServlet
			resp.sendRedirect(req.getContextPath() + "/login.html");
		}
	}

}
