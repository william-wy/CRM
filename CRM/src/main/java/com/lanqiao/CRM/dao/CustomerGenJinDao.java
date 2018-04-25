package com.lanqiao.CRM.dao;

import java.util.List;


import com.lanqiao.CRM.entity.CustomerGenJin;

public interface CustomerGenJinDao {
	public List<CustomerGenJin>  findAll();
	public List<CustomerGenJin>  findByCustomer(String customer);
	public void insert(CustomerGenJin customer);
	public List<CustomerGenJin>  findByWay(String way);
}
