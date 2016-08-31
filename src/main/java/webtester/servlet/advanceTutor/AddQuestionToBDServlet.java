package webtester.servlet.advanceTutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.form.QuestionForm;
import webtester.model.Question;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = { "/advance/addQuestionToBD" })
public class AddQuestionToBDServlet extends AbstractServlet {

	private static final long serialVersionUID = 3942634159842216710L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		QuestionForm form = createForm(QuestionForm.class, req);
		Long idTest = form.getIdTest();
		String name = form.getName();
		Question question = getAdvanceTutorService().save(new Question(idTest, name));
		System.out.println(question);
		resp.sendRedirect("/advance/home");
	}
	
}
