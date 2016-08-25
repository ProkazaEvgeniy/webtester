package webtester.servlet.tutor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Test;
import webtester.servlet.AbstractServlet;
@WebServlet(urlPatterns = "/tutor/home")
public class HomeTutorServlet extends AbstractServlet {

	private static final long serialVersionUID = -882940433909032259L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Test> list = getTutorServise().findAll();
		req.setAttribute("list", list);
		forwardTopage("tutor/home.jsp", req, resp);
	}
}
