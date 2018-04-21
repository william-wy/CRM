package com.lanqiao.CRM.service;

import java.util.List;
import com.lanqiao.CRM.entity.CustomerSea;
import com.lanqiao.CRM.utils.CustomerPage;
import com.lanqiao.CRM.utils.CustomerSeaPage;

public interface CustomerSeaService {
	public List<CustomerSea> findAll();
	public CustomerSea findById(int id);
	public CustomerSea findByKName(String kname);
	public int getTotal();
	public CustomerSeaPage getPage1(int pageno,int pagesize);
	public void insert (CustomerSea customer);
	public void deleteByArray(int[] kid);
	public void update(CustomerSea customer);
	public CustomerSeaPage findByKFid(int pageno, int pagesize,String kfid);
	public int getTotalByKfid(String kfid);
}
