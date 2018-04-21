package com.lanqiao.CRM.service;

import com.lanqiao.CRM.entity.Contract;
import com.lanqiao.CRM.utils.PageUtil;

public interface ContractService extends BaseService<Contract> {
	public PageUtil getPage1(int pageno,int pagesize);
	public PageUtil findByXFid(int pageno, int pagesize,String xfid);
}
