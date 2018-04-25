package com.lanqiao.CRM.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.PayPlanDao;
import com.lanqiao.CRM.entity.PayPlan;
import com.lanqiao.CRM.service.PayPlanService;
import com.lanqiao.CRM.utils.PageUtilPayPlan;

@Service
public class PayPlanServiceImpl implements PayPlanService{
	@Autowired
   private PayPlanDao payPlanDao; 
	
	
	public void setPayPlanDao(PayPlanDao payPlanDao) {
		this.payPlanDao = payPlanDao;
	}

	@Override
	public PageUtilPayPlan getPage1(int pageno, int pagesize) {
		Map<String,Integer> map=new HashMap<String,Integer>();
        PageUtilPayPlan  page=new PageUtilPayPlan();
        
		int total=payPlanDao.getTotal();
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);

		List list=payPlanDao.getPage(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return payPlanDao.getTotal();
	}

	@Override
	public void insert(PayPlan payPlan) {
		// TODO Auto-generated method stub
		payPlanDao.insert(payPlan);
	}

	@Override
	public void deleteByArray(int[] id) {
		// TODO Auto-generated method stub
		payPlanDao.deleteByArray(id);
	}

	@Override
	public PayPlan findByCusAndHeTong(String customer, String hetong) {
		// TODO Auto-generated method stub
		return payPlanDao.findByCusAndHeTong(customer, hetong);
	}

}
