
package com.lanqiao.CRM.dao;

import com.lanqiao.CRM.entity.Contract;

public interface ContractDao extends BaseDao<Contract>{
	
	public void updateStatus(String hstatus);
	
	public Contract getBusiness(int pc_id ,String hstatus);

}
