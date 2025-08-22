package w1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns= {"/hello"})

public class HelloServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		String name = "";

		// Nhận cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
		    for (Cookie c : cookies) {
		        if ("username".equals(c.getName())) {
		            name = c.getValue();
		        }
		    }
		}
		printWriter.println("Xin chao " + name);

	}
}
