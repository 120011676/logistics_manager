package com.logistics.manager.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;

/**
 * <b>@author</b> Say<br>
 * <b>email</b> 120011676@qq.com<br>
 */
public class HSSFCellHelper {

	private HSSFCell cell;

	public HSSFCellHelper(HSSFCell cell) {
		this.cell = cell;
	}
	
	public HSSFCell setCellStyle(HSSFCellStyle cellStyle) {
		cell.setCellStyle(cellStyle);
		return cell;
	}
	
}
