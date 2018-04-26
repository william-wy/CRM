package com.lanqiao.CRM.service;

import java.sql.SQLException;
import java.util.Map;

import com.lanqiao.CRM.entity.Contract;
import com.lanqiao.CRM.utils.PageUtil;

public interface ContractService extends BaseService<Contract> {
	public PageUtil<Contract> getPage1(int pageno,int pagesize);
	public PageUtil<Contract> findByXFid(int pageno, int pagesize,String xfid);
	
	public void updateStatus(String statu,int hid);
	
	public Contract getContract(String hstatus);
	
	public Contract getBusiness(int pc_id ,String hstatus);
	
	public void updateStatusById(Map<String,Object> map) throws Exception;
	public Contract get(int leaveid) throws SQLException;
}
