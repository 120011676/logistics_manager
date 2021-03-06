package com.logistics.manager.web.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.qq120011676.snow.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.logistics.manager.entity.UserEntity;
import com.logistics.manager.service.interfaces.IUserService;
import com.logistics.manager.web.action.base.BaseAction;

/**
 * <b>@author</b> Say<br>
 * <b>email</b> 120011676@qq.com<br>
 */
@Controller
@RequestMapping("user")
public class UserAction {

	@Autowired
	private IUserService userService;

	@RequestMapping("list")
	public String list(String username, String name) {
		Map<String, Object> map = new HashMap<>();
		if (!StringUtils.isNull(username)) {
			map.put("queryUsername", "%" + username + "%");
			BaseAction.getHttpServletRequest().setAttribute("username",
					username);
		}
		if (!StringUtils.isNull(name)) {
			map.put("queryName", "%" + name + "%");
			BaseAction.getHttpServletRequest().setAttribute("name", name);
		}
		BaseAction.getHttpServletRequest()
				.setAttribute(
						"page",
						this.userService.queryMySqlPage("querUser", map,
								new RowMapper<UserEntity>() {
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
										user.setCreateDatetime(resultSet
												.getTimestamp("create_datetime"));
										user.setEnable(resultSet
												.getBoolean("enable"));
										user.setPosition(resultSet
												.getBoolean("position"));
										return user;
									}
								}, BaseAction.getNowPage(), BaseAction
										.getOnePageRows()));
		return "user/list";
	}

	@RequestMapping("toUpdate")
	public String toUpdate(Integer id) {
		if (id != null) {
			get(id);
			return "user/update";
		}
		return "user/add";
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
		map.put("username", user.getUsername());
		map.put("name", user.getName());
		map.put("position", user.getPosition());
		if (user.getId() == null) {
			map.put("password", user.getPassword());
			this.userService.update("saveUser", map);
		} else {
			map.put("id", user.getId());
			this.userService.update("updateUser", map);
		}
		return "redirect:/user/list.htm";
	}

	@RequestMapping("delete")
	public String delete(Integer id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("enable", false);
		this.userService.update("updateUserByEnable", map);
		return "redirect:/user/list.htm";
	}

	@RequestMapping("recovery")
	public String recovery(Integer id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("enable", true);
		this.userService.update("updateUserByEnable", map);
		return "redirect:/user/list.htm";
	}

	@RequestMapping("look")
	public String look(Integer id) {
		get(id);
		return "user/look";
	}

	@RequestMapping("toUpdatePassword")
	public String toUpdatePassword(Integer id) {
		get(id);
		return "user/updatePassword";
	}

	@RequestMapping("updatePassword")
	public String updatePassword(UserEntity user) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", user.getId());
		map.put("newPassword", user.getPassword());
		this.userService.update("updateUserByPassword", map);
		return "redirect:/user/list.htm";
	}

	@RequestMapping("checkUsername")
	@ResponseBody
	public String checkUsername(Integer id, String username) {
		Map<String, Object> map = new HashMap<>();
		map.put("username", username);
		if (id != null) {
			map.put("id", id);
		}
		if (this.userService.queryForInt("checkUsername", map) > 0) {
			return "false";
		}
		return "true";
	}
}
