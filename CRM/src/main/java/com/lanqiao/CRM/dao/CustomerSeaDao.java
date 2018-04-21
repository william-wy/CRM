package com.lanqiao.CRM.dao;

import java.util.List;
import java.util.Map;
import com.lanqiao.CRM.entity.CustomerSea;

public interface CustomerSeaDao {
	public List<CustomerSea>  findAll();
	public CustomerSea findById(int kid);
	public CustomerSea findByKName(String kname);
	public List<CustomerSea> getPage(Map<String,Integer> map);
	public int getTotal();
	public void insert(CustomerSea klue);
	public void deleteByArray(int[] kid);
	public void update(CustomerSea customer);
	public List<CustomerSea> findByKFid(Map<Object,Object> map);
	public int getTotalByKfid(String kfid);
}
