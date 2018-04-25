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
	
	public List<Product> findByUnitAndLeibie(Map<Object,Object> map);
	
	public List<Product> findByNameAndLeibie(Map<Object,Object> map);
	
	public List<Product> getPage(Map<String,Integer> map);
	
	public int getTotal();

	public int getTotalByUnitAndLeibie(String unit,String sort);
	
	public int getTotalByNameAndLeibie(String pname,String sort);
	
	public List<Product> findByLeibie(Map<Object, Object> map);
	public int getTotalByLeibie(String sort);
	
}
