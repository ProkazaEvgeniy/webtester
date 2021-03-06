package webtester.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.form.AccountForm;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = { "/admin/editAccountToBD" })
public class EditAccountToBDServlet extends AbstractServlet {

	private static final long serialVersionUID = -6283581331901993461L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AccountForm form = createForm(AccountForm.class, req);
		int n = getAdminServise().update(form);
		if (n != 0) {
			System.out.println("Your data has been stored in the database");
		} else {
			System.out.println("Your data could not be stored in the database");
		}
		resp.sendRedirect("/admin/home");
	}
}
