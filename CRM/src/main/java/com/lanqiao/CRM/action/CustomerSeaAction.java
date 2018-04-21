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

import com.lanqiao.CRM.entity.Customer;
import com.lanqiao.CRM.entity.CustomerSea;
import com.lanqiao.CRM.service.CustomerSeaService;
import com.lanqiao.CRM.service.CustomerService;
import com.lanqiao.CRM.utils.CustomerPage;
import com.lanqiao.CRM.utils.CustomerSeaPage;
	@Controller
	@RequestMapping("/customersea")
	public class CustomerSeaAction {
		
	    @Autowired
		private CustomerSeaService customerSeaService;

		@RequestMapping(value="/getCustomerList.action")
		public @ResponseBody List<CustomerSea> getClueList() throws Exception {
			
			List<CustomerSea> customerlist=customerSeaService.findAll();
			
			
			return customerlist;
		}
		
		@RequestMapping("/ajax.action")
		public @ResponseBody CustomerSea test1() throws Exception {
		
			CustomerSea customer=customerSeaService.findById(2);
	           
			 return customer;
		}
		
		@RequestMapping(value="/all.action",method= {RequestMethod.POST,RequestMethod.GET})
		public @ResponseBody  CustomerSeaPage test2( int pageno, int pagesize) throws Exception{
	         
			CustomerSeaPage page=customerSeaService.getPage1(pageno, pagesize);
	                 
			 return page; 
		}
	    
		
		@RequestMapping(value="/ByKfid.action",method= {RequestMethod.POST,RequestMethod.GET})
		public @ResponseBody  CustomerSeaPage ByKfid( int pageno, int pagesize,String kid) throws Exception{
	         
			CustomerSeaPage page=customerSeaService.findByKFid(pageno, pagesize, kid);
	                 
			 return page; 
		}
		@RequestMapping(value="/addCustomer.action",method= {RequestMethod.POST,RequestMethod.GET})
		/**
		 * 提交表单用post， 表单属性在加一个 enctype="multipart/form-data"
		 * 直接自动绑定表单中与clue属性相同的
		 * ajax中如果用get方法提交，写data{xid:xid},
		 *      如果用post方法提交则直接在URL后面跟参数        url:'/ssm06/clue/deleteClue.action?xid='+xid,
		 *      然后action中的请求方法要一致
		 */
		public  @ResponseBody void  test3(HttpServletRequest req,HttpServletResponse res,CustomerSea customer){
			try {
				req.setCharacterEncoding("utf-8");
				res.setCharacterEncoding("utf-8");
				res.setContentType("text/html; charset=utf-8");

			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			System.out.println(customer.getKname());
			customerSeaService.insert(customer);
			   
				
		}
		
		
		@RequestMapping(value="/updateCustomer.action",method={RequestMethod.GET,RequestMethod.POST})
		public @ResponseBody CustomerSea test4(String s) throws UnsupportedEncodingException {
			   int kid=Integer.parseInt(s);
			   CustomerSea customer=customerSeaService.findById(kid);
			   
			   return customer; 
		}
   
		@RequestMapping(value="/delete.action",method={RequestMethod.GET,RequestMethod.POST})
		public  @ResponseBody void  delete(String s) {
		    
			String [] a=s.split(",");
		     int [] d =new int[a.length];
		     for(int i=0;i<a.length;i++) {
		    	 d[i]=Integer.parseInt(a[i]);
		     }
		     customerSeaService.deleteByArray(d);
	        
		}
		
		@RequestMapping(value="/saveCustomer.action",method={RequestMethod.GET,RequestMethod.POST})
		public  @ResponseBody String test6(CustomerSea customer,String id) {
		     
		     
	         if(id.equals("")) {
	        	 
	        	 customerSeaService.insert(customer);
				 return "insert succeed";
			 }
			 else if(!id.equals("")){
				 customer.setKid(Integer.parseInt(id));
				 customerSeaService.update(customer);
				 return "update succeed";
			 }else {
				 return "false";
			 }

		}
	  
		@RequestMapping(value="/findByKname.action",method={RequestMethod.GET,RequestMethod.POST})
		public @ResponseBody CustomerSea test7(String s) throws UnsupportedEncodingException {
			
			CustomerSea customer=customerSeaService.findByKName(s);
				return customer;
			
	          
		}
}
