package webtester.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Account;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = { "/admin/establishRole" })
public class EstablishRoleAccountServlet extends AbstractServlet {

	private static final long serialVersionUID = 3293718423115879369L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		long idAccount = Long.parseLong(id);
		Account account = getAdminServise().findByEdit(idAccount);
		req.setAttribute("account", account);
		forwardTopage("admin/establishRole.jsp", req, resp);
	}
}
