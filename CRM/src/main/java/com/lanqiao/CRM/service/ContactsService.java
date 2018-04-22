package com.lanqiao.CRM.service;

import java.util.List;
import java.util.Map;

import com.lanqiao.CRM.entity.Area;
import com.lanqiao.CRM.entity.Contacts;
import com.lanqiao.CRM.utils.ContactsPageUtil;


public interface ContactsService {
	public List<Contacts>  findAll();
	public Contacts findById(int l_id);
	public Contacts findByL_Name(String l_name);

	public int  getTotal();
	public ContactsPageUtil getPage1(int pageno,int pagesize);
	public void insert(Contacts contacts);
	public void deleteByArray(int[] l_id);
	public void update(Contacts contacts);
	public ContactsPageUtil findByL_fdeptno(int pageno, int pagesize,String l_fdeptno);
	public int getTotalByL_fdeptno(String l_fdeptno);

	public Area findById2(int id);
	
	public ContactsPageUtil findBySome(int pageno, int pagesize,Contacts contacts);
}
