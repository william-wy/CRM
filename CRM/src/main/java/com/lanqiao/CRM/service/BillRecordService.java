package com.lanqiao.CRM.service;

import com.lanqiao.CRM.entity.Billrecord;
import com.lanqiao.CRM.entity.PayPlan;
import com.lanqiao.CRM.utils.PageUtilBillRecord;


public interface BillRecordService {
	public PageUtilBillRecord getPage1(int pageno,int pagesize);
	public int getTotal();
	public void insert(Billrecord billRecord);
	public void deleteByArray(int[] id);
}
