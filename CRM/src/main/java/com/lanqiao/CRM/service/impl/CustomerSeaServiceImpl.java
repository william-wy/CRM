package com.lanqiao.CRM.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lanqiao.CRM.dao.CustomerSeaDao;
import com.lanqiao.CRM.entity.CustomerSea;
import com.lanqiao.CRM.service.CustomerSeaService;
import com.lanqiao.CRM.utils.CustomerPage;
import com.lanqiao.CRM.utils.CustomerSeaPage;

@Service
     public class CustomerSeaServiceImpl implements CustomerSeaService{
   
	@Autowired
    private CustomerSeaDao customerSeaDao;
	
	public void setCustomerSeaDao(CustomerSeaDao customerSeaDao) {
		this.customerSeaDao = customerSeaDao;
	}

	@Override
	public List<CustomerSea> findAll() {
		// TODO Auto-generated method stub
		return customerSeaDao.findAll();
	}

	@Override
	public CustomerSea findById(int id) {
		// TODO Auto-generated method stub
		return customerSeaDao.findById(id);
	}

	@Override
	public CustomerSea findByKName(String kname) {
		// TODO Auto-generated method stub
		return customerSeaDao.findByKName(kname);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return customerSeaDao.getTotal();
	}

	@Override
	public CustomerSeaPage getPage1(int pageno, int pagesize) {
		// TODO Auto-generated method stub
		Map<String,Integer> map=new HashMap<String,Integer>();
        CustomerSeaPage  page=new CustomerSeaPage();
       
		int total=customerSeaDao.getTotal();
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);
		List list=customerSeaDao.getPage(map);	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);
		return page;
	}

	@Override
	public void insert(CustomerSea customer) {
		// TODO Auto-generated method stub
		customerSeaDao.insert(customer);
	}

	@Override
	public void deleteByArray(int[] kid) {
		// TODO Auto-generated method stub
		customerSeaDao.deleteByArray(kid);
	}

	@Override
	public void update(CustomerSea customer) {
		// TODO Auto-generated method stub
		customerSeaDao.update(customer);
	}

	@Override
	public CustomerSeaPage findByKFid(int pageno, int pagesize, String kfid) {
		// TODO Auto-generated method stub
		Map<Object,Object> map=new HashMap<Object,Object>();
		CustomerSeaPage  page=new CustomerSeaPage();
        
		int total=customerSeaDao.getTotalByKfid(kfid);
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);
		map.put("xfid", kfid);
		List list=customerSeaDao.findByKFid(map);	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);
		return page;
	}

	@Override
	public int getTotalByKfid(String kfid) {
		// TODO Auto-generated method stub
		return customerSeaDao.getTotalByKfid(kfid);
	}
    
}
