package com.lanqiao.CRM.service;

import java.sql.SQLException;
import java.util.List;

import com.lanqiao.CRM.entity.Contract;
import com.lanqiao.CRM.utils.PageUtil;

public interface WorkFService {
	//启动流程 
		public void startProcess(int bkey,String username);
		
		//根据登录用户，查询用户的所有待办任务 
		public  List<Contract> getTaskList(String realName) throws SQLException;

		//查询用户的所有待办任务   easyUI分页显示
		public PageUtil<Contract> getTaskPage(String realName,int pageno,int pagesize)  throws SQLException ;

		//处理任务 
		public void completeProcess(String taskID,int i);

		PageUtil<Contract> getTaskPage3(String realName, boolean flag, int pageno, int pagesize) throws SQLException;

		void over(String taskID,int id);

		void Tokehu(String taskID,int id);

		public void over2(String taskId,int id);

		public void Tozongjingli(String taskId,int id);
}
