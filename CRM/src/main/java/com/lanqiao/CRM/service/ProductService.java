package com.lanqiao.CRM.service;

import java.util.List;
import java.util.Map;

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
	
	public int getTotalByUnitAndLeibie(String unit,String sort);
	public PageUtil findByUnitAndLeibie(int pageno, int pagesize,String unit,String sort);
		
	public int getTotalByNameAndLeibie(String pname,String sort);
	public PageUtil findByNameAndLeibie(int pageno, int pagesize,String pname,String sort);
	
	public PageUtil findByLeibie(int pageno, int pagesize,String sort);
	public int getTotalByLeibie(String sort);
}
