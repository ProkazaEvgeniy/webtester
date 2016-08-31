package webtester.servlet.advanceTutor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Answer;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = "/advance/home-answer")
public class HomeAnswerAdvanceTutorServlet extends AbstractServlet {

	private static final long serialVersionUID = -6775458591032566849L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Answer> list = getAdvanceTutorService().findAllAnswer();
		req.setAttribute("list", list);
		forwardTopage("advance/home-answer.jsp", req, resp);
	}
}
