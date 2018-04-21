package com.lanqiao.CRM.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.RoleDao;
import com.lanqiao.CRM.entity.PICharge;
import com.lanqiao.CRM.entity.Role;
import com.lanqiao.CRM.service.RoleService;
import com.lanqiao.CRM.utils.PageUtil;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao ;

	@Override
	public List<Role> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(PICharge user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PICharge user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Role> getPage(Map<String, Integer> map) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotal() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageUtil<Role> getPage2(int pageno, int pagesize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePerm(int roleid, int menuid) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
