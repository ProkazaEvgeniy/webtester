package webtester.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Account;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = { "/admin/editAccount", "/admin/addAccount" })
public class EditAccountServlet extends AbstractServlet {
	private static final long serialVersionUID = 2033472966680623822L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null) {
			long idAccount = Long.parseLong(id);
			Account account = getAdminServise().findByEdit(idAccount);
			req.setAttribute("account", account);
		} 
		forwardTopage("admin/account.jsp", req, resp);
	}
}
