package com.lanqiao.CRM.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.lanqiao.CRM.entity.PICharge;
import com.lanqiao.CRM.entity.Role;


public interface RoleDao{
	
    public List<Role> getAll() throws SQLException;
	
	public Role get(int id) throws SQLException;
	
	public int delete(int id) throws SQLException;
	
	public void insert(PICharge user) throws SQLException ;
	
	public void update(PICharge user) throws SQLException ;
	
	public List<Role> getPage(Map<String,Integer> map) throws SQLException ;

	public int getTotal() throws SQLException ;


	public void savePerm(Map<String,Integer> map);
}
