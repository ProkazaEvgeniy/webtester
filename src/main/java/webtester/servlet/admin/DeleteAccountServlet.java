package webtester.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.servlet.AbstractServlet;

@WebServlet("/admin/del")
public class DeleteAccountServlet extends AbstractServlet {
	private static final long serialVersionUID = 1787063928017901887L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getAdminServise().deleteAccount(Long.parseLong(req.getParameter("id")));
		resp.sendRedirect("/admin/home");
	}

}
