package webtester.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.Constatns;
import webtester.model.Account;
import webtester.model.Result;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = { "/student/testResultView" })
public class TestResultViewServlet extends AbstractServlet {

	private static final long serialVersionUID = -2009781122863536556L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Account account = (Account) req.getSession().getAttribute(Constatns.CURRENT_ACCOUNT);
		List<Result> listResult = getStudentService().findResultByIDAccount(account.getId());
		req.setAttribute("listResult", listResult);
		forwardTopage("student/viewResult.jsp", req, resp);
	}
}
