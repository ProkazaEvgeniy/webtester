package webtester.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Test;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns={"/student/passTest"})
public class PassTestStudentServlet extends AbstractServlet {

	private static final long serialVersionUID = -7946598465564403447L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id"));
		Test test = getStudentService().findAllforPassTest(id);
		req.setAttribute("test", test);
		forwardTopage("student/passTest.jsp", req, resp);
	}
}
