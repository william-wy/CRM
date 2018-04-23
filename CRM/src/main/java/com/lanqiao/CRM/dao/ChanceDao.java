package com.lanqiao.CRM.dao;

import java.util.List;
import java.util.Map;

import com.lanqiao.CRM.entity.Area;
import com.lanqiao.CRM.entity.Chance;
import com.lanqiao.CRM.entity.Clue;

public interface ChanceDao {
	
	public List<Chance>  findAll();
	public Chance findById(int jid);
	public Chance findByJname(String jname);

	public List<Chance> getPage(Map<String,Integer> map);
	public int getTotal();
	public void insert(Chance chance);
	public void deleteByArray(int[] jid);
	public void update(Chance chance);
	public List<Chance> findByJdept(Map<Object,Object> map);
	public int getTotalByJdept(String jdept);
	 
	public Area findById2(int id);

}
