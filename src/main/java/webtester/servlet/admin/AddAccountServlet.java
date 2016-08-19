package webtester.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.form.AccountForm;
import webtester.model.Account;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = { "/admin/addAccountToBD" })
public class AddAccountServlet extends AbstractServlet {

	private static final long serialVersionUID = -107094802202124796L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AccountForm form = createForm(AccountForm.class, req);
		String login = form.getLogin();
		String password = form.getPassword();
		String firstName = form.getFirstName();
		String lastName = form.getLastName();
		String secondName = form.getSecondName();
		String email = form.getEmail();
		Account account = getAdminServise().save(
				new Account(login, password, firstName, lastName, secondName,
						email));
		System.out.println(account);
		forwardTopage("/admin/home", req, resp);
	}

}
