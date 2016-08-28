package webtester.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.exception.WebtesterApplicationException;
import webtester.form.AccountForm;
import webtester.model.Account;
import webtester.model.AccountRole;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = { "/regAccountToBD" })
public class RegistationAccountToBDServlet extends AbstractServlet {

	private static final long serialVersionUID = -1412420349841334740L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AccountForm form = createForm(AccountForm.class, req);
		try{
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
			Account accountForRoleDefault = getAdminServise().findByLogin(login);
			AccountRole accountRole = getAdminServise().save(new AccountRole(accountForRoleDefault.getId(), 4));
			System.out.println(accountRole);
			resp.sendRedirect("/login");
		}catch (WebtesterApplicationException e) {
			req.setAttribute("error", e.getMessage());
			forwardTopage("login.jsp", req, resp);
		}
	}
	
}
