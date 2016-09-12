package webtester.servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.Constatns;
import webtester.model.Account;
import webtester.model.Result;
import webtester.model.TestResult;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns={"/student/resultTest"})
public class ResultServlet extends AbstractServlet {

	private static final long serialVersionUID = 1858834709756549822L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		TestResult testResult = (TestResult) req.getSession().getAttribute("TestResult");
		Double percent = getStudentService().entryResult(testResult);
		Account account = (Account) req.getSession().getAttribute(Constatns.CURRENT_ACCOUNT);
		Result result = getStudentService().save(new Result(testResult.getTest().getId(), account.getId(), percent, testResult.getTest().getName()));
		System.out.println(result);
		resp.sendRedirect("/student/testResultView?idAccount="+account.getId());
	}
}
