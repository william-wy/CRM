package com.lanqiao.CRM.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.CustomerDao;
import com.lanqiao.CRM.entity.Area;
import com.lanqiao.CRM.entity.Customer;
import com.lanqiao.CRM.service.CustomerService;
import com.lanqiao.CRM.utils.CustomerPage;
import com.lanqiao.CRM.utils.PageUtil;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		return customerDao.findById(id);
	}

	@Override
	public Customer findByKName(String kname) {
		// TODO Auto-generated method stub
		return customerDao.findByKName(kname);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return customerDao.getTotal();
	}

	@Override
	public CustomerPage getPage1(int pageno, int pagesize) {
		Map<String,Integer> map=new HashMap<String,Integer>();
         CustomerPage  page=new CustomerPage();
        
		int total=customerDao.getTotal();
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);

		List list=customerDao.getPage(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public void insert(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.insert(customer);
	}

	@Override
	public void deleteByArray(int[] kid) {
		// TODO Auto-generated method stub
		customerDao.deleteByArray(kid);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.update(customer);
	}

	@Override
	public CustomerPage findByKFid(int pageno, int pagesize, String kfid) {
		// TODO Auto-generated method stub
		Map<Object,Object> map=new HashMap<Object,Object>();
		CustomerPage  page=new CustomerPage();
        
		int total=customerDao.getTotalByKfid(kfid);
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);
		map.put("xfid", kfid);

		List list=customerDao.findByKFid(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public int getTotalByKfid(String kfid) {
		// TODO Auto-generated method stub
		return customerDao.getTotalByKfid(kfid);
	}

	@Override
	public Area findById2(int id) {
		// TODO Auto-generated method stub
		return customerDao.findById2(id);
	}

}
