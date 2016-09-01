package webtester.servlet.advanceTutor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Question;
import webtester.model.Test;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = {"/advance/editQuestion", "/advance/addQuestion"})
public class EditQuestionServlet extends AbstractServlet {

	private static final long serialVersionUID = -3834420641279607623L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null) {
			long idQuestion = Long.parseLong(id);
			Question question = getAdvanceTutorService().findByEdit(idQuestion);
			req.setAttribute("question", question);
			forwardTopage("advance/editQuestion.jsp", req, resp);
		} else {
			List<Test> listTest = getAdvanceTutorService().findAllListTest();
			req.setAttribute("listTest", listTest);
			forwardTopage("advance/addQuestion.jsp", req, resp);
		}
	}
}
