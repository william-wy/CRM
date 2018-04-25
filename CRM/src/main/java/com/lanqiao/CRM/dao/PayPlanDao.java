package com.lanqiao.CRM.dao;

import java.util.List;
import java.util.Map;

import com.lanqiao.CRM.entity.PayPlan;



public interface PayPlanDao {
	public List<PayPlan> getPage(Map<String,Integer> map);
	public int getTotal();
	public void insert(PayPlan payPlan);
	public void deleteByArray(int[] id);
	public PayPlan findByCusAndHeTong(String customer,String hetong);
}
