package com.lanqiao.CRM.service;

import java.util.List;
import com.lanqiao.CRM.entity.CustomerGenJin;

public interface CustomerGenJinService {
	public List<CustomerGenJin>  findAll();
	public List<CustomerGenJin>  findByCustomer(String customer);
	public void insert(CustomerGenJin customer);
	public List<CustomerGenJin>  findByWay(String way);
}
