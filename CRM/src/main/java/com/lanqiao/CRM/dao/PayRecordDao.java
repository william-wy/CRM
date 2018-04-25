package com.lanqiao.CRM.dao;

import java.util.List;
import java.util.Map;

import com.lanqiao.CRM.entity.PayRecord;



public interface PayRecordDao {
	public List<PayRecord> getPage(Map<String,Integer> map);
	public int getTotal();
	public void insert(PayRecord payRecord);
	public void deleteByArray(int[] id);
	
	public PayRecord findById(int id);
	public List<PayRecord> findByCusAndHetong(String Customer,String hetong);
	public List<PayRecord> findByPaydate(Map<String,Object> map);
	public int getTotalByPaydate(String paydate);
}
