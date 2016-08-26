package webtester.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Account;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = { "/admin/home" })
public class HomeAdminServlet extends AbstractServlet {
	private static final long serialVersionUID = 6071300428245450508L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Account> list = getAdminServise().findAll();
		req.setAttribute("list", list);
		
		/*
		List<AccountRole> listAccountRole = getAdminServise().findIdAccountRole(1L);
		req.setAttribute("listAccountRole", listAccountRole);
		*/
		
		forwardTopage("admin/home.jsp", req, resp);
	}
}
