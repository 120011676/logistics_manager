package com.logistics.manager.utils;

import java.util.Date;

/**
 * <b>@author</b> Say<br>
 * <b>email</b> 120011676@qq.com<br>
 */
public class OrderNumberUtils {

	private final static String PREFIX = "E";

	public static String getOrderNumber() {
		return PREFIX + new Date().getTime();
	}
}
