package webtester.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.Constatns;
import webtester.exception.ValidationException;
import webtester.form.LoginForm;
import webtester.model.Account;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends AbstractServlet {
	private static final long serialVersionUID = 5698529372032989806L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute(Constatns.CURRENT_ACCOUNT) != null) {
			resp.sendRedirect("/admin/home");
		} else {
			forwardTopage("login.jsp", req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LoginForm form = createForm(LoginForm.class, req);
		try {
			Account account = getCommonService().login(form);
			req.getSession().setAttribute(Constatns.CURRENT_ACCOUNT, account);
			if (form.isRememberMe()) {
				String token = getCommonService().generateRememberMeToken(account);
				Cookie cookie = new Cookie(Constatns.ALC, token);
				cookie.setMaxAge(3600 * 24 * 7);
				resp.addCookie(cookie);
			}
			if (form.getRole() == Constatns.ROLE_ADMIN) {
				resp.sendRedirect("/admin/home");
			} else if (form.getRole() == Constatns.ROLE_STUDENT) {
				resp.sendRedirect("/student/home");
			} else if (form.getRole() == Constatns.ROLE_ADVANCE_TUTOR) {
				resp.sendRedirect("/advance/home");
			} else if (form.getRole() == Constatns.ROLE_TUTOR) {
				resp.sendRedirect("/tutor/home");
			}
		} catch (ValidationException e) {
			req.setAttribute("error", e.getMessage());
			forwardTopage("login.jsp", req, resp);
		}
	}
}
