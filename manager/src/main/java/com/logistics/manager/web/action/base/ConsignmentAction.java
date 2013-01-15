package com.logistics.manager.web.action.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("consignment")
public class ConsignmentAction {

	@RequestMapping("list")
	public String list() {
		BaseAction.getHttpServletRequest().setAttribute("current", "consignment");
		BaseAction.getHttpServletRequest().setAttribute("show", "consignment_show");
		BaseAction.getHttpServletRequest().setAttribute("subShow", "consignment_show_acceptance");
		return "consignment/list";
	}
}
