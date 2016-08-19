package webtester.servlet;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.service.AdminService;
import webtester.service.CommonServise;
import webtester.service.impl.ServiceManager;

public abstract class AbstractServlet extends HttpServlet {
	private static final long serialVersionUID = 8043921765169590751L;

	private ServiceManager serviceManager;

	@Override
	public final void init() throws ServletException {
		serviceManager = ServiceManager.getInstance(getServletContext());
		initServlet();
	}

	@Override
	public final void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public final void initServlet() throws ServletException {

	}

	public CommonServise getCommonService() {
		return serviceManager.getCommonServise();
	}

	public AdminService getAdminServise() {
		return serviceManager.getAdminService();
	}

	protected void forwardTopage(String page, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("currentPage", page);
		req.getRequestDispatcher("/WEB-INF/view/page-template.jsp").forward(req, resp);
	}

	protected <T> T createForm(Class<T> formClass, HttpServletRequest req) {
		try {
			T form = formClass.newInstance();
			Field[] fields = formClass.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				String value = req.getParameter(field.getName());
				Object convertedValue = convert(field.getType(), value);
				field.set(form, convertedValue);
			}
			return form;
		} catch (InstantiationException | IllegalAccessException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	private Object convert(Class<?> type, String value) {
		if (type == String.class)
			return value;
		else if (type == Integer.TYPE)
			return Integer.parseInt(value);
		else if (type == Boolean.TYPE)
			return value != null;
		else
			throw new IllegalArgumentException("Can`t convert to " + type);
	}

}
