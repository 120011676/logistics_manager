package com.logistics.manager.web.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.qq120011676.snow.properties.ProjectProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logistics.manager.entity.UserEntity;
import com.logistics.manager.service.interfaces.IUserService;
import com.logistics.manager.web.action.base.BaseAction;

/**
 * <b>@author</b> Say<br>
 * <b>email</b> 120011676@qq.com<br>
 */
@Controller
@RequestMapping("my")
public class MyAction {

	@Autowired
	private IUserService userService;

	@RequestMapping("toUpdate")
	public String toUpdate(Integer id, String messages) {
		get(id);
		BaseAction.getHttpServletRequest().setAttribute("messages", messages);
		return "my/update";
	}

	private void get(Integer id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		BaseAction.getHttpServletRequest().setAttribute(
				"user",
				this.userService.queryForObject("querUser", map,
						new RowMapper<UserEntity>() {
							@Override
							public UserEntity mapRow(ResultSet rs, int arg1)
									throws SQLException {
								UserEntity user = new UserEntity();
								user.setId(rs.getInt("id"));
								user.setName(rs.getString("name"));
								user.setUsername(rs.getString("username"));
								user.setCreateDatetime(rs
										.getTimestamp("create_datetime"));
								user.setPosition(rs.getBoolean("position"));
								return user;
							}
						}));
	}

	@RequestMapping("update")
	public String update(UserEntity user) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", user.getId());
		map.put("name", user.getName());
		this.userService.update("updateUserByName", map);
		return this.toUpdate(user.getId(),
				ProjectProperties.getConfig("updateMyUserInfo"));
	}

	@RequestMapping("toPassword")
	public String toPassword(Integer id, String messages) {
		get(id);
		BaseAction.getHttpServletRequest().setAttribute("messages", messages);
		return "my/updatePassword";
	}

	@RequestMapping("updatePassword")
	public String updatePassword(UserEntity user, String newPassword) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", user.getId());
		map.put("password", user.getPassword());
		map.put("newPassword", newPassword);
		int u = this.userService.update("updateUserByPassword", map);
		if (u > 0) {
			return "redirect:/noSecurity/logout.htm";
		}
		return this.toPassword(user.getId(),
				ProjectProperties.getConfig("updatePasswordError"));
	}
}
