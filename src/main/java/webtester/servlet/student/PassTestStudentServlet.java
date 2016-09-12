package webtester.servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.TestResult;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = { "/student/passTest" })
public class PassTestStudentServlet extends AbstractServlet {

	private static final long serialVersionUID = -7946598465564403447L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id"));
		TestResult tr = new TestResult();
		tr.setTest(getStudentService().findAllforPassTest(id));
		req.getSession().setAttribute("TestResult", tr);
		resp.sendRedirect("/student/nextQuestion?idTest=" + id + "&offset=0");
	}
}
