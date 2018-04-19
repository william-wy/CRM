package com.lanqiao.CRM.dao;

import java.util.List;
import java.util.Map;

import com.lanqiao.CRM.entity.Product;

public interface ProductDao {
	
	public void deleteByArray(int[] pid);
	public void insert(Product p);
	public void update(Product p);
	public Product findByPname(String pname);
	public Product findByPid(int pid);
	public List<Product> findByUnit(Map<Object,Object> map);
	public List<Product> findByGuige(Map<Object,Object> map);
	public List<Product> findByIntrodu(Map<Object,Object> map);
	
	public List<Product> getPage(Map<String,Integer> map);
	public int getTotal();

	public int getTotalByUnit(String unit);
	public int getTotalByGuige(String guige);
	public int getTotalByIntrodu(String introdu);
	
}
