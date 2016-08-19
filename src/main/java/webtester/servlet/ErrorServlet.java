package webtester.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/error" })
public class ErrorServlet extends AbstractServlet {
	private static final long serialVersionUID = 6071300428245450508L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forwardTopage("error.jsp", req, resp);
		//req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
	}
}
