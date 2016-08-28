package webtester.servlet.tutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.form.TestForm;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = {"/tutor/editTestToBD"})
public class EditTestToBDServlet extends AbstractServlet {

	private static final long serialVersionUID = -3937366776616910137L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		TestForm form = createForm(TestForm.class, req);
		int n = getTutorServise().update(form);
		if (n != 0) {
			System.out.println("Your data has been stored in the database");
		} else {
			System.out.println("Your data could not be stored in the database");
		}
		resp.sendRedirect("/tutor/home");
	}
}
