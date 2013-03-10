package com.logistics.manager.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * <b>@author</b> Say<br>
 * <b>email</b> 120011676@qq.com<br>
 */
public class MenuSelectFilter implements Filter {

	private final static String MENU = "menu";

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
		if (uri.startsWith("/user/")) {
			servletRequest.setAttribute(MENU, "user");
		} else if (uri.startsWith("/consignment/")) {
			servletRequest.setAttribute(MENU, "consignment");
		} else if (uri.startsWith("/delivery/")) {
			servletRequest.setAttribute(MENU, "delivery");
		} else if (uri.startsWith("/take/")) {
			servletRequest.setAttribute(MENU, "take");
		} else if (uri.startsWith("/all/")) {
			servletRequest.setAttribute(MENU, "all");
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
