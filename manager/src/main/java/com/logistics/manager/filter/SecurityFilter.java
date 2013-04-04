package com.logistics.manager.filter;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.qq120011676.snow.springmvc.util.SpringIOCUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.logistics.manager.entity.UserEntity;
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
		if (request.getSession().getAttribute(BaseAction.LOGIN_USER) == null) {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					System.out.println(cookie.getName());
					if ("username".equals(cookie.getName())) {
						Map<String, Object> map = new HashMap<>();
						map.put("username", cookie.getValue());
						map.put("enable", true);
						UserEntity user = this.userService.queryForObject(
								"querUser", map, new RowMapper<UserEntity>() {
									@Override
									public UserEntity mapRow(
											ResultSet resultSet, int arg1)
											throws SQLException {
										UserEntity user = new UserEntity();
										user.setId(resultSet.getInt("id"));
										user.setUsername(resultSet
												.getString("username"));
										user.setName(resultSet
												.getString("name"));
										user.setPosition(resultSet
												.getBoolean("position"));
										return user;
									}
								});
						if (user != null) {
							request.getSession().setAttribute(
									BaseAction.LOGIN_USER, user);
						}
					}
				}
			}
		}
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
