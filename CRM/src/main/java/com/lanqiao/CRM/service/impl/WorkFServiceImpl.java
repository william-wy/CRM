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
import com.lanqiao.CRM.service.ContractService;
import com.lanqiao.CRM.service.WorkFService;
import com.lanqiao.CRM.utils.PageUtil;
@Service
public class WorkFServiceImpl implements WorkFService{
	    	@Autowired
			private  RuntimeService runtimeService ;
			@Autowired
			private TaskService taskService ;
			@Autowired
			private ContractService contractService;
			
	@Override
	public void startProcess(int key, String username) {
		System.out.println("-=-============");
				String bkey = "leave:"+key ;   // leave:1
				Map<String,Object> variables = new HashMap<String,Object>();
				variables.put("总经理", username) ;
				runtimeService.startProcessInstanceByKey("CRMProcess", bkey, variables);
		
				contractService.updateStatus("等待总经理审批",key);
	}

	

	@Override
	public List<Contract> getTaskList(String realName) throws SQLException {

		 List<Contract> list = new ArrayList<>();
		 List<Task> taskList = taskService.createTaskQuery()
				  			   .taskAssignee(realName)
				  			   .list();
		 
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
			 
			 int leaveid = Integer.parseInt(key.split(":")[1]);
			 
			 Contract contract0 = contractService.get(leaveid) ;
			
			 String taskID = task.getId();
			 int tId =Integer.parseInt(taskID);
			 contract0.setDeptno(tId);
			 list.add(contract0);
		 }
			
			return list;
	}

	@Override
	public PageUtil<Contract> getTaskPage(String realName, int pageno, int pagesize) throws SQLException {
		Map<String,Integer> map=new HashMap<>();
        PageUtil<Contract>  page=new PageUtil<>();
        
		int total=(int)taskService.createTaskQuery()
				   .taskAssignee(realName)
				   .count() ;
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);

		List list=getTaskList(realName);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public void completeProcess(String hid,int id) {
	
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put("产品经理", "ff") ;
		variables.put("flag",7);
		add("等待产品经理理审批",id);
		taskService.complete(hid, variables);
		
		
	}

	@Override
	public PageUtil<Contract> getTaskPage3(String realName, boolean flag, int pageno, int pagesize)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void over(String taskID,int id) {
		add("完成审核",id);
		taskService.complete(taskID);
	}
	public void add(String str,int i){
		System.out.println("WorkFServiceImpl.add()进入");
		contractService.updateStatus(str,i);
		System.out.println("WorkFServiceImpl.add()出来");
	}
	@Override
	public void Tokehu(String taskID,int id) {
		// TODO Auto-generated method stub
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put("客户经理", "cc") ;
		variables.put("flag",3);
		taskService.complete(taskID, variables);
		contractService.updateStatus("等待客户经理理审批",id);
	}

	@Override
	public void over2(String taskId,int id) {
		// TODO Auto-generated method stub
				Map<String,Object> variables = new HashMap<String,Object>();
				variables.put("back",6) ;
				add("作废",id);
				taskService.complete(taskId,variables);
	}

	@Override
	public void Tozongjingli(String taskId,int id) {
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put("总", "zz") ;
		variables.put("back",3);
		taskService.complete(taskId, variables);
		add("提交总经理",id);
	}

}
