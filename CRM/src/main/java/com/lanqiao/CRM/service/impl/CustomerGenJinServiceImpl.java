package com.lanqiao.CRM.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.CustomerGenJinDao;
import com.lanqiao.CRM.entity.CustomerGenJin;
import com.lanqiao.CRM.service.CustomerGenJinService;

@Service
public class CustomerGenJinServiceImpl implements CustomerGenJinService {

	@Autowired
    private CustomerGenJinDao customerGenJinDao;
	
	public void setCustomerGenJinDao(CustomerGenJinDao customerGenJinDao) {
		this.customerGenJinDao = customerGenJinDao;
	}

	@Override
	public List<CustomerGenJin> findByCustomer(String customer) {
		// TODO Auto-generated method stub
		return customerGenJinDao.findByCustomer(customer);
	}

	@Override
	public void insert(CustomerGenJin customer) {
		// TODO Auto-generated method stub
		customerGenJinDao.insert(customer);
	}

	@Override
	public List<CustomerGenJin> findByWay(String way) {
		// TODO Auto-generated method stub
		return customerGenJinDao.findByWay(way);
	}

	@Override
	public List<CustomerGenJin> findAll() {
		// TODO Auto-generated method stub
		return customerGenJinDao.findAll();
	}

}
