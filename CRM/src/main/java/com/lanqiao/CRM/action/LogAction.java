package com.lanqiao.CRM.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.CRM.entity.Log;
import com.lanqiao.CRM.service.LogService;
import com.lanqiao.CRM.utils.PageUtil;

@Controller
@RequestMapping("/log")
public class LogAction {
	@Autowired
   private LogService logService;

	public void setLogService(LogService logService) {
		this.logService = logService;
	}
   
	
	@RequestMapping(value="/all.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody  List test2(String s) throws Exception{
         if(s.equals("clue")) {
         List list=logService.findAll("clue");
         return list; 
         }
		 return null; 
	}
	
	
}
