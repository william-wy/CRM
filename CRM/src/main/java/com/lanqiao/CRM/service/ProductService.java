package com.lanqiao.CRM.service;

import com.lanqiao.CRM.entity.Product;
import com.lanqiao.CRM.utils.PageUtil;

public interface ProductService {
	
	public void deleteByArray(int[] pid);
	public void insert(Product p);
	public void update(Product p);
	public Product findByPname(String pname);
	public Product findByPid(int pid);
	
	public int getTotal();
	public PageUtil getPage(int pageno, int pagesize);
	
	public int getTotalByUnit(String unit);
	public PageUtil findByUnit(int pageno, int pagesize,String unit);
	
	public int getTotalByGuige(String guige);
	public PageUtil findByGuige(int pageno, int pagesize,String guige);
	
	public int getTotalByIntrodu(String introdu);
	public PageUtil findByIntrodu(int pageno, int pagesize,String introdu);
}
