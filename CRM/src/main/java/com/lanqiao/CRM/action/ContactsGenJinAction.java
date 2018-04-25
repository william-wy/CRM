package com.lanqiao.CRM.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.CRM.entity.ContactsGenJin;
import com.lanqiao.CRM.service.ContactsGenJinService;

@Controller
@RequestMapping("/contactsgenjin")
public class ContactsGenJinAction {
	@Autowired
    private ContactsGenJinService contactsGenJinService;

	public void setContacts(ContactsGenJinService contactsGenJinService) {
		this.contactsGenJinService = contactsGenJinService;
	}
	
	@RequestMapping(value="/save.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody String test1(ContactsGenJin contacts,HttpServletRequest req,HttpServletResponse res) {
		try {
	
		contactsGenJinService.insert(contacts);
		return "insert succeed";
		}catch(Exception e) {
			return "false";
		} 
	}
	
	@RequestMapping(value="/findByContacts.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody List<ContactsGenJin> findByContacts(String contacts,HttpServletRequest req,HttpServletResponse res) {
         
		
		return contactsGenJinService.findByContacts(contacts);
		
	}
	
}

