package com.logistics.manager;

import java.text.DecimalFormat;

/**
 * <b>@author</b> Say<br>
 * <b>email</b> 120011676@qq.com<br>
 */
public class DoubleTest {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0.00"); 
		String num = df.format(Double.MAX_VALUE); 
		System.out.println(num);
	}
}
