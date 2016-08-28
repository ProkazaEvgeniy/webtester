package webtester.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = { "/regAccount" })
public class ReqistrationAccountServlet extends AbstractServlet {

	private static final long serialVersionUID = 3630566204219051782L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null) {
			forwardTopage("login.jsp", req, resp);
		} else {
			forwardTopage("reqAccount.jsp", req, resp);
		}
	}
}
