package com.logistics.manager.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * <b>@author</b> Say<br>
 * <b>email</b> 120011676@qq.com<br>
 */
public class ResultSetHelper {

	private ResultSet rs;

	public ResultSetHelper(ResultSet rs) {
		this.rs = rs;
	}

	public Integer getInt(String name) throws SQLException {
		if (isNull(name)) {
			return null;
		}
		return this.rs.getInt(name);
	}

	public Double getDouble(String name) throws SQLException {
		if (isNull(name)) {
			return null;
		}
		return this.rs.getDouble(name);
	}

	public Boolean getBoolean(String name) throws SQLException {
		if (isNull(name)) {
			return null;
		}
		return this.rs.getBoolean(name);
	}

	public String getString(String name) throws SQLException {
		return this.rs.getString(name);
	}

	public Date getDate(String name) throws SQLException {
		return this.rs.getDate(name);
	}

	public Date getTimestamp(String name) throws SQLException {
		return this.rs.getDate(name);
	}

	private boolean isNull(String name) throws SQLException {
		if (this.rs.getObject(name) == null) {
			return true;
		}
		return false;
	}
}
