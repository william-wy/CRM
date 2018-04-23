package com.lanqiao.CRM.dao;

import java.util.List;
import java.util.Map;

import com.lanqiao.CRM.entity.Jur;
import com.lanqiao.CRM.entity.PICharge;
import com.lanqiao.CRM.entity.RoleUser;
import com.lanqiao.CRM.utils.PageUtil;

public interface JurUtilDao {
	
	public List<Jur> getPage(Map<String,Integer> map);
	public int getTotal();
	public Jur findById(int id);
	
	public void insert(Jur jur);
	public void update(Jur jur);
	
	public void update2(RoleUser roleUser);
	
} 
