package webtester.servlet.advanceTutor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Question;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns = "/advance/home")
public class HomeQuestionAdvanceTutorServlet extends AbstractServlet {

	private static final long serialVersionUID = 8077249555811102437L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Question> list = getAdvanceTutorService().findAll();
		req.setAttribute("list", list);
		
		forwardTopage("advance/home.jsp", req, resp);
	}
}
