package com.lanqiao.CRM.service;

import java.sql.SQLException;
import java.util.List;

public interface BaseService<T> {
	public int delete(int id) throws SQLException;

	public int save(T user) throws SQLException;

	public int getTotal() throws SQLException;

	public List<T> getPage(int pageno, int pagesize) throws SQLException;
}
