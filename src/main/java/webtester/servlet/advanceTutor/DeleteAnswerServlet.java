package webtester.servlet.advanceTutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns={"/advance/delAnswer"})
public class DeleteAnswerServlet extends AbstractServlet {

	private static final long serialVersionUID = -4818590164578633151L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		getAdvanceTutorService().deleteAnswer(Long.parseLong(req.getParameter("id")));
		resp.sendRedirect("/advance/home-answer");
	}
}
