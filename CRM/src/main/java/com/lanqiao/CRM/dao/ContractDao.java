
package com.lanqiao.CRM.dao;

import java.util.Map;

import com.lanqiao.CRM.entity.Contract;

public interface ContractDao extends BaseDao<Contract>{
	
	public void updateStatus(Map<String,Object> map);
	
	public Contract getBusiness(int pc_id ,String hstatus);

	public void updateStatusById(Map<String,Object> map) throws Exception;
}
