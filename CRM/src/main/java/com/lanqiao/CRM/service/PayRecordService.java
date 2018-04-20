package com.lanqiao.CRM.service;

import com.lanqiao.CRM.entity.PayPlan;
import com.lanqiao.CRM.entity.PayRecord;
import com.lanqiao.CRM.utils.PageUtilPayRecord;

public interface PayRecordService {
	public PageUtilPayRecord getPage1(int pageno,int pagesize);
	public int getTotal();
	public void insert(PayRecord payRecord);
	public void deleteByArray(int[] id);
}
