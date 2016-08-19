package webtester.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.Constatns;
import webtester.model.Account;
import webtester.service.CommonServise;
import webtester.service.impl.ServiceManager;

@WebFilter(filterName = "AutoLoginFilter")
public class AutoLoginFilter extends AbstractFilter {

	private CommonServise commonService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		commonService = ServiceManager.getInstance(filterConfig.getServletContext()).getCommonServise();
	}

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		if (req.getSession().getAttribute(Constatns.CURRENT_ACCOUNT) == null) {
			for (Cookie cookie : req.getCookies()) {
				if (cookie.getName().equals(Constatns.ALC)) {
					String token = cookie.getValue();
					Account account = commonService.findByRememberMeToken(token);
					if (account != null) {
						req.getSession().setAttribute(Constatns.CURRENT_ACCOUNT, account);
					}
				}
			}
		}
		chain.doFilter(req, resp);
	}

}
