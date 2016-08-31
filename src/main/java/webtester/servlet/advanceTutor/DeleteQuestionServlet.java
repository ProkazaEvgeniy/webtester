package webtester.servlet.advanceTutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns={"/advance/del"})
public class DeleteQuestionServlet extends AbstractServlet {

	private static final long serialVersionUID = 2023407133198121452L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		getAdvanceTutorService().deleteQuestion(Long.parseLong(req.getParameter("id")));
		resp.sendRedirect("/advance/home");
	}
}
