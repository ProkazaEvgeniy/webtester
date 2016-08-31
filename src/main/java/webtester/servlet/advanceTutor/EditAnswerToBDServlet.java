package webtester.servlet.advanceTutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.form.AnswerForm;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns={"/advance/editAnswerToBD"})
public class EditAnswerToBDServlet extends AbstractServlet {

	private static final long serialVersionUID = 2665890439602002162L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AnswerForm form = createForm(AnswerForm.class, req);
		int n = getAdvanceTutorService().update(form);
		if (n != 0) {
			System.out.println("Your data has been stored in the database");
		} else {
			System.out.println("Your data could not be stored in the database");
		}
		resp.sendRedirect("/advance/home-answer");
	}
}
