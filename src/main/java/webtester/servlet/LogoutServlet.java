package webtester.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.Constatns;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends AbstractServlet {
	private static final long serialVersionUID = 5698529372032989806L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		Cookie cookie = new Cookie(Constatns.ALC, null);
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		resp.sendRedirect("/login");
	}
}
