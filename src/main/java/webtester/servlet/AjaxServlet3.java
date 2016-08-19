package webtester.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Account;

@WebServlet(urlPatterns = "/accounts-json")
public class AjaxServlet3 extends AbstractServlet {

	private static final long serialVersionUID = -2389381994211106214L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Account> list = getAdminServise().findAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/view/ajax-accounts-json.jsp").forward(req, resp);
	}
}
