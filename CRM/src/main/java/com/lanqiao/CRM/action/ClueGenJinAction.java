package com.lanqiao.CRM.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.CRM.entity.ClueGenJin;
import com.lanqiao.CRM.service.ClueGenJinService;


@Controller
@RequestMapping("/genjin")
public class ClueGenJinAction {
	@Autowired
    private ClueGenJinService clueGenJinService;

	public void setClue(ClueGenJinService clueGenJinService) {
		this.clueGenJinService = clueGenJinService;
	}
	
	@RequestMapping(value="/save.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody String test1(ClueGenJin clue,HttpServletRequest req,HttpServletResponse res) {
		try {
		
		clueGenJinService.insert(clue);
		return "insert succeed";
		}catch(Exception e) {
			return "false";
		} 
	}
	
	@RequestMapping(value="/findByClue.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody List<ClueGenJin> findByClue(String clue,HttpServletRequest req,HttpServletResponse res) {
         
		
		return clueGenJinService.findByClue(clue);
		
	}
	
	
}
