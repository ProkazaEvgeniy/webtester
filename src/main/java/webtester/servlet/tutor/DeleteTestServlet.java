package webtester.servlet.tutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.servlet.AbstractServlet;

@WebServlet("/tutor/del")
public class DeleteTestServlet extends AbstractServlet {

	private static final long serialVersionUID = 2857815413824368273L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getTutorServise().deleteTest(Long.parseLong(req.getParameter("id")));
		resp.sendRedirect("/tutor/home");
	}
}
