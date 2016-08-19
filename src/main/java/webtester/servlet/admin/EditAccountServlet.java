package webtester.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.form.AccountForm;
import webtester.model.Account;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = { "/admin/editAccount", "/admin/addAccount" })
public class EditAccountServlet extends AbstractServlet {
	private static final long serialVersionUID = 2033472966680623822L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String action = req.getParameter("action");
		if (id != null) {
			long idAccount = Long.parseLong(id);
			Account account = getAdminServise().findByEdit(idAccount);
			req.setAttribute("account", account);
		}
		if("addAccount".equals(action)){
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
		if("editAccount".equals(action)){
			AccountForm form = createForm(AccountForm.class, req);
			int n = getAdminServise().update(form);
			if(n != 0){			
				resp.sendRedirect("/admin/home");
			} else {
				System.out.println("not do yet");
			}
		}
		forwardTopage("admin/account.jsp", req, resp);
	}
	
	
}
