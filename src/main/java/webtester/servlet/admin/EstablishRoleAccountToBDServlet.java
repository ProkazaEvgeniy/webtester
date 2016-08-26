package webtester.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.form.EstablishRoleForm;
import webtester.model.AccountRole;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = { "/admin/establishRoleToBD" })
public class EstablishRoleAccountToBDServlet extends AbstractServlet {

	private static final long serialVersionUID = 2308949863976395468L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EstablishRoleForm form = createForm(EstablishRoleForm.class, req);
		long idAccount = Long.parseLong(req.getParameter("id"));
		int idRole = form.getRole();
		AccountRole accountRole = getAdminServise().save(new AccountRole(idAccount, idRole));
		System.out.println(accountRole);
		resp.sendRedirect("/admin/home");
	}
}
