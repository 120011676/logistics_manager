package com.logistics.manager.web.action.base;

import javax.servlet.http.HttpServletRequest;

import org.qq120011676.snow.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.logistics.manager.entity.UserEntity;

public class BaseAction {

	public static final String LOGIN_USER = "LOGIN_USER";

	public static HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
	}

	public static UserEntity getLoginUser() {
		Object obj = getHttpServletRequest().getSession().getAttribute(
				LOGIN_USER);
		if (obj instanceof UserEntity) {
			return (UserEntity) obj;
		}
		return null;
	}

	public static String getIpAddr() {
		HttpServletRequest request = BaseAction.getHttpServletRequest();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static int getNowPage() {
		String nowPage = getHttpServletRequest().getParameter("nowPage");
		if (StringUtils.isNull(nowPage)) {
			return 0;
		} else {
			return Integer.parseInt(nowPage);
		}
	}

	public static int getOnePageRows() {
		String maxNum = getHttpServletRequest().getParameter("onePageRows");
		if (StringUtils.isNull(maxNum)) {
			return 20;
		} else {
			return Integer.parseInt(maxNum);
		}
	}
}
