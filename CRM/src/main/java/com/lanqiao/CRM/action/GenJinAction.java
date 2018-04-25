package com.lanqiao.CRM.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.lanqiao.CRM.entity.CustomerGenJin;
import com.lanqiao.CRM.service.ClueGenJinService;
import com.lanqiao.CRM.service.CustomerGenJinService;

@Controller
@RequestMapping("/genjinall")
public class GenJinAction {
	@Autowired
    private ClueGenJinService clueGenJinService;
	
	@Autowired
    private CustomerGenJinService customerGenJinService;
	


	public void setClueGenJinService(ClueGenJinService clueGenJinService) {
		this.clueGenJinService = clueGenJinService;
	}

	

	
	public void setCustomerGenJinService(CustomerGenJinService customerGenJinService) {
		this.customerGenJinService = customerGenJinService;
	}

	@RequestMapping(value="/find.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody List findByClue(HttpServletRequest req,HttpServletResponse res) {
        List list=new ArrayList();
		List list1=clueGenJinService.findAll();    
        List list2=customerGenJinService.findAll();
        list.addAll(list1);
        list.addAll(list2);
		return list;
	}
	
	
}

