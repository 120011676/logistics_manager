package com.logistics.manager.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <b>@author</b> Say<br>
 * <b>email</b> 120011676@qq.com<br>
 */
@Controller
@RequestMapping("user")
public class UserAction {

	@RequestMapping("list")
	public String list() {
		return "user/list";
	}
}
