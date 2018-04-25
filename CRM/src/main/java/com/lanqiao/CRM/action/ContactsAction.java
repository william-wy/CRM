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


import com.lanqiao.CRM.entity.Contacts;
import com.lanqiao.CRM.service.ContactsService;
import com.lanqiao.CRM.utils.ContactsPageUtil;


@Controller
@RequestMapping("/contacts")
public class ContactsAction {
	
    @Autowired
	private ContactsService contactsService;

	@RequestMapping(value="/getContactsList.action")
	public @ResponseBody List<Contacts> getContactsList() throws Exception {
		
		List<Contacts> contactslist=contactsService.findAll();
		
		
		return contactslist;
	}
	
	@RequestMapping("/ajax.action")
	public @ResponseBody Contacts test1() throws Exception {
	
		Contacts contacts=contactsService.findById(2);
           
		 return contacts;
	}
	
	@RequestMapping(value="/all.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody  ContactsPageUtil test2( int pageno, int pagesize) throws Exception{
         
		ContactsPageUtil page=contactsService.getPage1(pageno, pagesize);
                 
		 return page; 
	}
    
	
	@RequestMapping(value="/ByL_fdeptno.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody  ContactsPageUtil ByL_fdeptno( int pageno, int pagesize,String fid) throws Exception{
         
		ContactsPageUtil page=contactsService.findByL_fdeptno(pageno, pagesize, fid);
                 
		 return page; 
	}
	@RequestMapping(value="/addContacts.action",method= {RequestMethod.POST,RequestMethod.GET})
	/**
	 * 提交表单用post， 表单属性在加一个 enctype="multipart/form-data"
	 * 直接自动绑定表单中与clue属性相同的
	 * ajax中如果用get方法提交，写data{xid:xid},
	 *      如果用post方法提交则直接在URL后面跟参数        url:'/ssm06/clue/deleteClue.action?xid='+xid,
	 *      然后action中的请求方法要一致
	 */
	public  @ResponseBody void  test3(HttpServletRequest req,HttpServletResponse res,Contacts contacts){
		try {
			req.setCharacterEncoding("utf-8");
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html; charset=utf-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		System.out.println(contacts.getL_name());
		contactsService.insert(contacts);
		   
			
	}
	
	
	@RequestMapping(value="/updateContacts.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Contacts test4(String s) throws UnsupportedEncodingException {
		   int l_id=Integer.parseInt(s);
		   Contacts contacts=contactsService.findById(l_id);
		   
		   return contacts; 
	}
	

	
   
	@RequestMapping(value="/delete.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody String  delete(String s) {
		if(s.equals("")) {
			 return "false";
		}else {
	     String [] a=s.split(",");
	     
	     int [] d =new int[a.length];
	     for(int i=0;i<a.length;i++) {
	    	 d[i]=Integer.parseInt(a[i]);
	     }
	     contactsService.deleteByArray(d);
	     return "delete succeed";
		}
	}
	
	@RequestMapping(value="/saveContacts.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody String test6(Contacts contacts,String id) {
	     
	     System.out.println(id+"------------------------------");
         if(id.equals("")) {
        	 
        	 contactsService.insert(contacts);
			 return "insert succeed";
		 }
		 else if(!id.equals("")){
			 contacts.setL_id(Integer.parseInt(id));
			 contactsService.update(contacts);
			 return "update succeed";
		 }else {
			 return "false";
		 }

	}
  
	@RequestMapping(value="/findByL_name.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Contacts test7(String s) throws UnsupportedEncodingException {
		
			Contacts contacts=contactsService.findByL_Name(s);
			return contacts;     
	}
	@RequestMapping(value="/findByL_id.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Contacts test8(int l_id) throws UnsupportedEncodingException {
		    
		     System.out.println(l_id);
		Contacts contacts=contactsService.findById(l_id);
		//contacts.setL_area(contactsService.findById2(Integer.parseInt(contacts.getL_area())).getName());
			return contacts;   
	}
	
	
}
