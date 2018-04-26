package com.lanqiao.CRM.action;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.CRM.entity.Contract;
import com.lanqiao.CRM.service.ContractService;
import com.lanqiao.CRM.service.WorkFService;
import com.lanqiao.CRM.utils.PageUtil;


@Controller
@RequestMapping("/WF")
public class WFAction {

	@Autowired
	private ContractService contractservice ;
	
	@Autowired
	private WorkFService wfService ;
	
	@RequestMapping("/get.action")
	public @ResponseBody Contract get(){
		return new Contract();
	}
	/**
	 * 请假单列表
	 * @param leaveService
	 * @throws SQLException 
	 */
	@RequestMapping("/getPage.action")
	public @ResponseBody PageUtil<Contract> getPage(int page,int rows) throws SQLException{
		PageUtil<Contract> pagelist =  contractservice.getPage1(page, rows) ;
		return pagelist;
	}

	public void setLeaveService(ContractService contractservice) {
		this.contractservice = contractservice;
	}
	
	
	
	// 启动流程
	@RequestMapping("/startProcess.action")
	public @ResponseBody String start(String leaveId){
		System.out.println("leaveId====="+leaveId);
		int id =Integer.parseInt(leaveId);
		System.out.println("id======"+id);
		wfService.startProcess(id, "张速度");
		
		return "yes" ;
	}
	
	//得到所有待办任务 （根据用户得到）
	@RequestMapping("/getTaskList.action")
	public @ResponseBody PageUtil<Contract> getTaskList(HttpSession session,int pageno,int pagesize) throws SQLException{
		System.out.println("WFAction.getTaskList()进入");
		
		PageUtil<Contract> list = wfService.getTaskPage("总经理", pageno, pagesize) ;
		System.out.println(list);
		return list ;
	}
	@RequestMapping("/getTaskList1.action")
	public @ResponseBody PageUtil<Contract> getTaskList1(HttpSession session,int pageno,int pagesize) throws SQLException{
		System.out.println("WFAction.getTaskList1()进入");
		
		PageUtil<Contract> list = wfService.getTaskPage("产品经理", pageno, pagesize) ;
		System.out.println(list);
		return list ;
	}
	@RequestMapping("/getTaskList2.action")
	public @ResponseBody PageUtil<Contract> getTaskList2(HttpSession session,int pageno,int pagesize) throws SQLException{
		System.out.println("WFAction.getTaskList1()进入");
		
		PageUtil<Contract> list = wfService.getTaskPage("客户经理", pageno, pagesize) ;
		System.out.println(list);
		return list ;
	}
	
	@RequestMapping("/completeProcess.action")
	public @ResponseBody String completeProcess(String taskId ,int id){
		
		
		wfService.completeProcess(taskId, id);
		return "yes" ;
	}
	@RequestMapping("/Tochanpin.action")
	public @ResponseBody String chanpinTo(String taskId,int id){
		
		
		wfService.Tokehu(taskId,id);
		return "yes" ;
	}
	@RequestMapping("/overrr.action")
	public @ResponseBody String over(String taskId,int id){
		System.out.println("WFAction.over()进入");
		wfService.over(taskId,id);
		return "yes" ;
	}
	@RequestMapping("/over2.action")
	public @ResponseBody String over2(String taskId,int id){
		
		
		wfService.over2(taskId,id);
		return "yes" ;
	}

	@RequestMapping("/Tozongjingli.action")
	public @ResponseBody String Tozongjingli(String taskId,int id){
		
		
		wfService.Tozongjingli(taskId,id);
		return "yes" ;
	}

}
