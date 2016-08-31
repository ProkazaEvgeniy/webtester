package webtester.servlet.advanceTutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.form.QuestionForm;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns={"/advance/editQuestionToBD"})
public class EditQuestionToBDServlet extends AbstractServlet {

	private static final long serialVersionUID = -4408103277978930849L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		QuestionForm form = createForm(QuestionForm.class, req);
		int n = getAdvanceTutorService().update(form);
		if (n != 0) {
			System.out.println("Your data has been stored in the database");
		} else {
			System.out.println("Your data could not be stored in the database");
		}
		resp.sendRedirect("/advance/home");
	}
}
