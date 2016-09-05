package webtester.servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.form.NextQuestionForm;
import webtester.model.Question;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns={"/student/nextQuestion"})
public class PassNextTestStudentServlet extends AbstractServlet {

	private static final long serialVersionUID = 4266489853325515439L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		NextQuestionForm form = createForm(NextQuestionForm.class, req);
		Question test = getStudentService().findQuestionByID(form.getIdQuestion());
		req.setAttribute("test", test);
		forwardTopage("student/passNextTest.jsp", req, resp);
	}
}
