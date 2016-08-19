package webtester.servlet.tutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.servlet.AbstractServlet;
@WebServlet(urlPatterns = "/tutor/home")
public class TutorServlet extends AbstractServlet {

	private static final long serialVersionUID = -882940433909032259L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forwardTopage("tutor/home.jsp", req, resp);
	}
}
