package com.lanqiao.CRM.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface BaseDao<T> {
	public List<T> getAll() throws SQLException;

	public T get(int id) throws SQLException;

	public int delete(int id) throws SQLException;

	public int insert(T t) throws SQLException;

	public int update(T tm) throws SQLException;

	public List<T> getPage(Map<String, Integer> map) throws SQLException;

	public int getTotal() throws SQLException;
}
