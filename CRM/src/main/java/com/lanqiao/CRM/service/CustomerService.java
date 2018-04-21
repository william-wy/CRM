package com.lanqiao.CRM.service;

import java.util.List;

import com.lanqiao.CRM.entity.Area;
import com.lanqiao.CRM.entity.Customer;
import com.lanqiao.CRM.utils.CustomerPage;

public interface CustomerService {
	public List<Customer> findAll();
	public Customer findById(int id);
	public Customer findByKName(String kname);
	public int getTotal();
	public CustomerPage getPage1(int pageno,int pagesize);
	public void insert (Customer customer);
	public void deleteByArray(int[] kid);
	public void update(Customer customer);
	public CustomerPage findByKFid(int pageno, int pagesize,String kfid);
	public int getTotalByKfid(String kfid);
	public Area findById2(int id);
}
