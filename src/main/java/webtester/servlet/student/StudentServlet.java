package webtester.servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.servlet.AbstractServlet;

@WebServlet(urlPatterns={"/student/home"})
public class StudentServlet extends AbstractServlet {

	private static final long serialVersionUID = 6698716447730550556L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forwardTopage("student/home.jsp", req, resp);
	}

}
