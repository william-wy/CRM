package com.lanqiao.CRM.action;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.CRM.entity.Contract;
import com.lanqiao.CRM.service.ContractService;
import com.lanqiao.CRM.utils.PageUtil;

@Controller
@RequestMapping("/contract")
public class ContractAction {
	@Autowired
	ContractService service;
	@RequestMapping("/getPage.action")
	public @ResponseBody  PageUtil<?> test2( int pageno, int pagesize) throws Exception{
         PageUtil<?> page=service.getPage1(pageno, pagesize);
		 return page; 
	}
	@RequestMapping("/getPage1.action")
	public @ResponseBody List<Contract> getPage(int pageno,int pagesize){
		System.out.println(pageno+" "+pagesize);
		List<Contract> list = null;
		try {
			 list  = service.getPage(pageno, pagesize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
	@RequestMapping("/contract.action")
	public String page(){
		System.out.println("ContractAction.page()");
		return "contract";
	}
	@RequestMapping(value="/saveContract.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody String save(Contract contract){

		System.out.println("======================");
		System.out.println(contract.getHname());
		int i = -1;
		try {
			i=service.save(contract);
			System.out.println("niahihasdihihdis"+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if (i<0) {
			return "error";
		}else{
			return "success";
		}
	}
	@RequestMapping("/delate.action")
	public @ResponseBody String delate(int id){
		int i=0;
		try {
			service.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	
	}
	
	@RequestMapping(value="/getCount.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody int getCount() throws Exception{
         
         int count=service.getTotal();
                 
		 return count; 
	}
	
}
