package webtester.servlet.tutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Test;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = { "/tutor/editTest", "/tutor/addTest" })
public class EditTestServlet extends AbstractServlet {

	private static final long serialVersionUID = 685163263348521606L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null) {
			long idTest = Long.parseLong(id);
			Test test = getTutorServise().findByID(idTest);
			req.setAttribute("test", test);
			forwardTopage("tutor/editTest.jsp", req, resp);
		} else {
			forwardTopage("tutor/addTest.jsp", req, resp);
		}
	}
}
