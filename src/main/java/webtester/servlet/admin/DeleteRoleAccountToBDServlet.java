package webtester.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns={"/admin/deleteRoleToBD"})
public class DeleteRoleAccountToBDServlet extends AbstractServlet {

	private static final long serialVersionUID = -7727037959024724638L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		getAdminServise().deleteAccountRole(Long.parseLong(req.getParameter("id")), Long.parseLong(req.getParameter("role")));
		resp.sendRedirect("/admin/home");
	}
}
