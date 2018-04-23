package com.lanqiao.CRM.service;

import java.util.List;

import com.lanqiao.CRM.entity.Area;
import com.lanqiao.CRM.entity.Chance;
import com.lanqiao.CRM.utils.ChancePageUtil;


public interface ChanceService {
	
	public List<Chance> findAll();
	public Chance findById(int jid);
	public Chance findByJname(String jname);

	public int getTotal();
	public ChancePageUtil getPage1(int pageno,int pagesize);
	public void insert (Chance chance);
	public void deleteByArray(int[] jid);
	public void update(Chance chance);
	public ChancePageUtil findByJdept(int pageno, int pagesize,String jdept);
	public int getTotalByJdept(String jdept);
	public Area findById2(int id);
	
}
