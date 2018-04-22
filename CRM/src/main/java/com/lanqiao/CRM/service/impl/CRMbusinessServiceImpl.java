package com.lanqiao.CRM.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.entity.Contract;
import com.lanqiao.CRM.service.CRMbusinessService;
import com.lanqiao.CRM.service.ContractService;
import com.lanqiao.CRM.utils.PageUtil;

@Service
public class CRMbusinessServiceImpl implements CRMbusinessService{

	@Autowired
	private  RuntimeService runtimeService ;
	@Autowired
	private TaskService taskService ;
	@Autowired
	private ContractService contractService ;
	
	
	@Override
	public void startProcess(String key,String username) {
		
		String bkey = "leave:"+key ;
		
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put("zjl", username) ;
		runtimeService.startProcessInstanceByKey("CRMbusiness", bkey, variables);
		//runtimeService.startProcessInstanceByKey("leaveProcess", variables) ;
		contractService.updateStatus("未批准");
		
	}


	@Override
	public List<Contract> getTaskList(int pc_id,String realName) throws SQLException {
		
		 List<Contract> list = new ArrayList<Contract>();
		 List<Task> taskList = taskService.createTaskQuery()
				  			   .taskAssignee(realName)
				  			   .list() ;
		 
		 //遍历待办任务列表taskList
		 for(Task task : taskList){
			 
			 //得到当前task的流程实例ID 
			 String piID = task.getProcessInstanceId() ;
			 
			 //根据流程实例ID，得到流程实例
			 ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
					 						.processInstanceId(piID)
					 						.singleResult();
			 //得到业务数据key  leave:1
			 String key = processInstance.getBusinessKey() ;
			 
			 String leaveid = key.split(":")[1];
			 
			 Contract contract = contractService.getBusiness(pc_id, leaveid); ;
			
			 String taskID = task.getId() ;
			 contract.setTaskID(taskID);
			 list.add(contract) ;
		 }
		
		return list;
	}


	@Override
	public PageUtil<Contract> getTaskPage(int pc_id,String realName, int pageno, int pagesize) throws SQLException {
		PageUtil<Contract> page = new PageUtil<Contract>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		int totalNum = (int) taskService.createTaskQuery()
					   .taskAssignee(realName)
					   .count() ;
		int total=contractService.getTotal();
		int pageTotal = totalNum % pagesize == 0 ? totalNum / pagesize : totalNum / pagesize + 1 ;
		
		if(pageno > pageTotal){
			pageno = pageTotal ;
		}
		if(pageno <= 0){
			pageno = 1 ;
		}
		map.put("start", (pageno-1)*pagesize) ;
		map.put("end", pagesize) ;
		
		
		List<Contract> list = getTaskList(pc_id,realName);
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);
		
		return page;
	}


	@Override
	public void completeProcess(String taskID) {
		
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put("xizhurenGroup", "系主任") ;
		taskService.complete(taskID, variables);
		contractService.updateStatus("");
		
	}
	
	
}
