package webtester.servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.form.NextQuestionForm;
import webtester.model.QuestionAnswer;
import webtester.model.TestResult;
import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns={"/student/validate"})
public class ValidateServlet extends AbstractServlet {

	private static final long serialVersionUID = 3657270650468383751L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		NextQuestionForm form = createForm(NextQuestionForm.class, req);
		TestResult tr = (TestResult) req.getSession().getAttribute("TestResult");
		tr.add(new QuestionAnswer(form.getIdQuestion(), form.getName()));
		resp.sendRedirect("/student/nextQuestion?idTest="+form.getIdTest()+"&offset="+form.getOffset());
	}
}
