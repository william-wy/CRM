package com.lanqiao.CRM.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.CRM.entity.CustomerGenJin;
import com.lanqiao.CRM.service.CustomerGenJinService;

@Controller
@RequestMapping("/cugenjin")
public class CustomerGenJinAction {
	@Autowired
    private CustomerGenJinService customerGenJinService;

	
	public void setCustomerGenJinService(CustomerGenJinService customerGenJinService) {
		this.customerGenJinService = customerGenJinService;
	}

	@RequestMapping(value="/save.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody String test1(CustomerGenJin customer,HttpServletRequest req,HttpServletResponse res) {
		try {
		
			customerGenJinService.insert(customer);
		return "insert succeed";
		}catch(Exception e) {
			return "false";
		} 
	}
	
	@RequestMapping(value="/findByCustomer.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody List<CustomerGenJin> findByClue(String customer,HttpServletRequest req,HttpServletResponse res) {

		return customerGenJinService.findByCustomer(customer);
		
	}
}
