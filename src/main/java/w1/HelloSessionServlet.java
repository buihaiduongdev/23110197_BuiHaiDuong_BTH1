package w1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/hello-session")
public class HelloSessionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  HttpSession session = req.getSession(false);
	        String user = (session != null) ? (String) session.getAttribute("username") : null;

	        if (user == null) {
	            resp.sendRedirect("login-session.html");
	            return;
	        }

	        resp.setContentType("text/html;charset=UTF-8");
	        resp.getWriter().println("<h2>Xin chào " + user + " (Session)</h2>");
			resp.getWriter().println("<a href='" + req.getContextPath() + "/logout-session'>Logout</a>");
	}
}
