package com.lanqiao.CRM.service;

import com.lanqiao.CRM.entity.PayPlan;

import com.lanqiao.CRM.utils.PageUtilPayPlan;

public interface PayPlanService {
	public PageUtilPayPlan getPage1(int pageno,int pagesize);
	public int getTotal();
	public void insert(PayPlan payPlan);
	public void deleteByArray(int[] id);
	
	public PayPlan findByCusAndHeTong(String customer,String hetong);
}
