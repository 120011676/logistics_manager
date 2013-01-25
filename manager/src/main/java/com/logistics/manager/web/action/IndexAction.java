package com.logistics.manager.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexAction {

	@RequestMapping("index")
	public String index() {
		return "index";
	}
}
