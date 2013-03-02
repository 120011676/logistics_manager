package com.logistics.manager.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.qq120011676.snow.springmvc.util.SpringIOCUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.logistics.manager.service.impl.UserServiceImpl;
import com.logistics.manager.service.interfaces.IUserService;
import com.logistics.manager.web.action.base.BaseAction;

public class SecurityFilter implements Filter {

	@Autowired
	private IUserService userService;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String uri = request.getRequestURI().substring(
				request.getContextPath().length());
		if (request.getSession().getAttribute(BaseAction.LOGIN_USER) != null
				|| uri.startsWith("/noSecurity/") || uri.startsWith("/css/")
				|| uri.startsWith("/js/") || uri.startsWith("/images/")) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			HttpServletResponse response = (HttpServletResponse) servletResponse;
			response.sendRedirect(request.getContextPath()
					+ "/noSecurity/login.htm");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.userService = SpringIOCUtils.getBean(
				filterConfig.getServletContext(), UserServiceImpl.class);
	}

}
