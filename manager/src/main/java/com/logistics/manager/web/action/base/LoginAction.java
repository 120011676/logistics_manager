package com.logistics.manager.web.action.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logistics.manager.entity.UserEntity;
import com.logistics.manager.service.interfaces.IUserService;

@Controller
@RequestMapping("noSecurity")
public class LoginAction {

	@Autowired
	private IUserService userService;

	@RequestMapping("login")
	public String login() {
		return "login/login";
	}

	@RequestMapping("toLogin")
	public String toLogin(String username, String password) {
		Map<String, Object> map = new HashMap<>();
		map.put("username", username);
		UserEntity user = this.userService.query("querUser", map,
				new ResultSetExtractor<UserEntity>() {
					@Override
					public UserEntity extractData(ResultSet resultSet)
							throws SQLException, DataAccessException {
						if (resultSet.next()) {
							UserEntity user = new UserEntity();
							user.setId(resultSet.getInt("id"));
							user.setUsername(resultSet.getString("username"));
							user.setPassword(resultSet.getString("password"));
							user.setName(resultSet.getString("name"));
							return user;
						}
						return null;
					}
				});
		if (user != null && password.equals(user.getPassword())) {
			BaseAction.getHttpServletRequest().getSession()
					.setAttribute(BaseAction.LOGIN_USER, user);
			return "redirect:/";
		}
		return "redirect:/login.htm?error=true";
	}
}
