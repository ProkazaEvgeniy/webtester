package webtester.servlet.advanceTutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.form.AnswerForm;
import webtester.model.Answer;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = { "/advance/addAnswerToBD" })
public class AddAnswerToBDServlet extends AbstractServlet {

	private static final long serialVersionUID = 7782703022810395719L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AnswerForm form = createForm(AnswerForm.class, req);
		Long idQuestion = form.getIdQuestion();
		String name = form.getName();
		Boolean correct = form.getCorrect();
		Answer answer = getAdvanceTutorService().save(new Answer(idQuestion, name, correct));
		System.out.println(answer);
		resp.sendRedirect("/advance/home-answer");
	}
}
