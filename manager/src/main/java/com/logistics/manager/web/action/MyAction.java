package com.logistics.manager.web.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
	public String toUpdate(Integer id) {
		Map<String, Object> map = new HashMap<>();
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
								return user;
							}
						}));
		return "my/update";
	}

	@RequestMapping("update")
	public String update(UserEntity user) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", user.getId());
		map.put("name", user.getName());
		this.userService.update("updateUserByName", map);
		return "redirect:/my/toUpdate.htm?id=" + user.getId();
	}
}
