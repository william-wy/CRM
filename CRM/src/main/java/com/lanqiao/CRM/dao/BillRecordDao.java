package com.lanqiao.CRM.dao;

import java.util.List;
import java.util.Map;

import com.lanqiao.CRM.entity.Billrecord;



public interface BillRecordDao {
	public List<Billrecord> getPage(Map<String,Integer> map);
	public int getTotal();
	public void insert(Billrecord billRecord);
	public void deleteByArray(int[] id);
}
