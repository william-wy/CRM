package com.lanqiao.CRM.service;

import java.sql.SQLException;
import java.util.List;

import com.lanqiao.CRM.entity.Contract;
import com.lanqiao.CRM.utils.PageUtil;

public interface CRMbusinessService {

	//启动流程 
	public void startProcess(String bkey,String username);
	
	//根据登录用户，查询用户的所有待办任务 
	public  List<Contract> getTaskList(int pc_id,String realName) throws SQLException;

	//查询用户的所有待办任务   easyUI分页显示
	public PageUtil<Contract> getTaskPage(int pc_id,String realName,int pageno,int pagesize)  throws SQLException ;

	//处理任务 
	public void completeProcess(String taskID);
}
