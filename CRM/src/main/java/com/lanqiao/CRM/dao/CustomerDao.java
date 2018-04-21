package com.lanqiao.CRM.dao;

import java.util.List;
import java.util.Map;

import com.lanqiao.CRM.entity.Area;
import com.lanqiao.CRM.entity.Customer;

public interface CustomerDao {
	public List<Customer>  findAll();
	public Customer findById(int kid);
	public Customer findByKName(String kname);
	public List<Customer> getPage(Map<String,Integer> map);
	public int getTotal();
	public void insert(Customer klue);
	public void deleteByArray(int[] kid);
	public void update(Customer customer);
	public List<Customer> findByKFid(Map<Object,Object> map);
	public int getTotalByKfid(String kfid);
	public Area findById2(int id);
}
