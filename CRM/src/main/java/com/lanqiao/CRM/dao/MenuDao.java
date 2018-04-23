package com.lanqiao.CRM.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.lanqiao.CRM.entity.Menu;
import com.lanqiao.CRM.entity.Role;


public interface MenuDao{
	
    public List<Menu> getAll() throws SQLException;

	public List<Menu> getMenuByRole(int roleid);
	
	public List<Role> getAllRole() ;
	
	public void saveFengpei(Map<String,Integer> map);
	
	public int getRole(int pc_id);

}
