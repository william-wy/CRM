package com.lanqiao.CRM.action;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.CRM.entity.Clue;
import com.lanqiao.CRM.entity.Jur;
import com.lanqiao.CRM.entity.PICharge;
import com.lanqiao.CRM.entity.RoleUser;
import com.lanqiao.CRM.service.JurUtilService;
import com.lanqiao.CRM.utils.PageUtil;
@Controller
@RequestMapping("/jur")
public class JurUtilAction {
		@Autowired
		private JurUtilService jurUtilService ;
		public void setJurUtilService(JurUtilService jurUtilService) {
			this.jurUtilService = jurUtilService;
		}

		@RequestMapping(value="/all.action",method= {RequestMethod.POST,RequestMethod.GET})
		public @ResponseBody  PageUtil test2( int pageno, int pagesize) throws Exception{         
	         PageUtil page=jurUtilService.getPage1(pageno, pagesize);                
			 return page; 
		}
		@RequestMapping(value="/updaterole.action",method={RequestMethod.GET,RequestMethod.POST})
		public @ResponseBody String test4(int user_id,int role_id) throws UnsupportedEncodingException {
			   
			   RoleUser roleUser=new RoleUser();
			   
			   roleUser.setRole_id(role_id);
			   roleUser.setUser_id(user_id);
			   System.out.println(role_id);
			   System.out.println(user_id);
			   jurUtilService.update2(roleUser);
			   
			   return "sucess"; 
		}
		
}
