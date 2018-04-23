package com.lanqiao.CRM.service;

import java.sql.SQLException;
import java.util.List;

import com.lanqiao.CRM.entity.Menu;
import com.lanqiao.CRM.entity.Role;
import com.lanqiao.CRM.utils.MenuTree;
import com.lanqiao.CRM.utils.PageUtil;

public interface MenuService{
	
    public List<Menu> getAll() throws SQLException;
	
	public Menu get(int id) throws SQLException;
	
	public int delete(int id) throws SQLException;
	
	public int getTotal() throws SQLException ;
	
	public PageUtil<Menu> getPage2(int pageno,int pagesize) throws SQLException ;

	public List<MenuTree> getMenuTreeByRole(int roleid);
	
	public List<MenuTree> getMenuTree(int roleid) throws SQLException;
	
	public List<Role> getAllRole() ;
	
	public void saveFengpei(int roleid,int userid);
	
	public int getRole(int pc_id);
	
}
