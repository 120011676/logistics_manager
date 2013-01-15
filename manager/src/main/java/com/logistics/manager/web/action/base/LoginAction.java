package com.logistics.manager.web.action.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginAction {

	@RequestMapping("login")
	public String login() {
		System.out.println("login");
		return "login/login";
	}
}
