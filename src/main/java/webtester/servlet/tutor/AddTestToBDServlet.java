package webtester.servlet.tutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.Constatns;
import webtester.form.TestForm;
import webtester.model.Account;
import webtester.model.Test;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = { "/tutor/addTestToBD" })
public class AddTestToBDServlet extends AbstractServlet {

	private static final long serialVersionUID = -107094802202124796L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		TestForm form = createForm(TestForm.class, req);
		Account account = (Account) req.getSession().getAttribute(Constatns.CURRENT_ACCOUNT);
		Long idAccount = account.getId();
		String name = form.getName();
		String description = form.getDescription();
		int durationPerQuestion = form.getDurationPerQuestion();
		Test test = getTutorServise().save(new Test(idAccount, name, description, durationPerQuestion));
		System.out.println(test);
		resp.sendRedirect("/tutor/home");
	}

}
