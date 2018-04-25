package com.lanqiao.CRM.service;

import java.util.List;

import com.lanqiao.CRM.entity.PayPlan;
import com.lanqiao.CRM.entity.PayRecord;
import com.lanqiao.CRM.utils.PageUtilPayRecord;

public interface PayRecordService {
	public PageUtilPayRecord getPage1(int pageno,int pagesize);
	public int getTotal();
	public void insert(PayRecord payRecord);
	public void deleteByArray(int[] id);
	public PayRecord findById(int id);
	public List<PayRecord> findByCusAndHetong(String Customer,String hetong);
	
	public PageUtilPayRecord findByPaydate(int pageno,int pagesize,String paydate);
	public int getTotalByPaydate(String paydate);
}
