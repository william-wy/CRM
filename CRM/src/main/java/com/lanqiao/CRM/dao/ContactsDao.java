package com.lanqiao.CRM.dao;

import java.util.List;
import java.util.Map;

import com.lanqiao.CRM.entity.Area;

import com.lanqiao.CRM.entity.Contacts;

public interface ContactsDao {
	public List<Contacts>  findAll();
	public Contacts findById(int l_id);
	public Contacts findByL_Name(String l_name);

	public List<Contacts> getPage(Map<String,Integer> map);
	public int  getTotal();
	public void insert(Contacts contacts);
	public void deleteByArray(int[] l_id);
	public void update(Contacts contacts);
	public List<Contacts> findByL_fdeptno(Map<Object,Object> map);
	public int getTotalByL_fdeptno(String l_fdeptno);

	public Area findById2(int id);
	
	public int getTotalBySome(Contacts contacts);
	public List<Contacts> findBySome(Map<String,Object> map);

}
