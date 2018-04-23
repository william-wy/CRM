package com.lanqiao.CRM.service;
import java.util.List;
import java.util.Map;
import com.lanqiao.CRM.entity.Jur;
import com.lanqiao.CRM.entity.PICharge;
import com.lanqiao.CRM.entity.RoleUser;
import com.lanqiao.CRM.utils.PageUtil;

public interface JurUtilService {

	public int getTotal();
	public PageUtil getPage1(int pageno,int pagesize);
	public Jur findById(int id);
	
	public void insert (Jur jur);
	public void update(Jur jur);
	public void update2(RoleUser roleUser);
	
	

}
