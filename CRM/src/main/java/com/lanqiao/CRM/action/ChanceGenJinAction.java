package com.lanqiao.CRM.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.CRM.entity.ChanceGenJin;
import com.lanqiao.CRM.service.ChanceGenJinService;


@Controller
@RequestMapping("/chancegenjin")
public class ChanceGenJinAction {
	@Autowired
    private ChanceGenJinService chanceGenJinService;

	public void setChance(ChanceGenJinService chanceGenJinService) {
		this.chanceGenJinService = chanceGenJinService;
	}
	
	@RequestMapping(value="/save.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody String test1(ChanceGenJin chance,HttpServletRequest req,HttpServletResponse res) {
		try {
	
			chanceGenJinService.insert(chance);
		return "insert succeed";
		}catch(Exception e) {
			return "false";
		} 
	}
	
	@RequestMapping(value="/findByChance.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody List<ChanceGenJin> findByChance(String chance,HttpServletRequest req,HttpServletResponse res) {
         System.out.println("===================");
		
		return chanceGenJinService.findByChance(chance);
		
	}
	
}

