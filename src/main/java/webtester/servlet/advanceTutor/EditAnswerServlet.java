package webtester.servlet.advanceTutor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.model.Answer;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns={"/advance/editAnswer", "/advance/addAnswer"})
public class EditAnswerServlet extends AbstractServlet {

	private static final long serialVersionUID = 1347812803354754521L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null) {
			long idAnswer = Long.parseLong(id);
			Answer answer = getAdvanceTutorService().findByEditAnswer(idAnswer);
			req.setAttribute("answer", answer);
			forwardTopage("advance/editAnswer.jsp", req, resp);
		} else {
			forwardTopage("advance/addAnswer.jsp", req, resp);
		}
	}
}
