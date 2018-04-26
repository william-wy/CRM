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
import com.lanqiao.CRM.entity.Customer;
import com.lanqiao.CRM.entity.CustomerSea;
import com.lanqiao.CRM.service.CustomerSeaService;
import com.lanqiao.CRM.service.CustomerService;
import com.lanqiao.CRM.utils.CustomerPage;



	@Controller
	@RequestMapping("/customer")
	public class CustomerAction {
		
	    @Autowired
		private CustomerService customerService;
	    @Autowired
	    private CustomerSeaService sea;

		@RequestMapping(value="/getCustomerList.action")
		public @ResponseBody List<Customer> getClueList() throws Exception {
			
			List<Customer> customerlist=customerService.findAll();
			
			
			return customerlist;
		}
		
		@RequestMapping("/ajax.action")
		public @ResponseBody Customer test1() throws Exception {
		
			Customer customer=customerService.findById(2);
	           
			 return customer;
		}
		
		@RequestMapping(value="/all.action",method= {RequestMethod.POST,RequestMethod.GET})
		public @ResponseBody  CustomerPage test2( int pageno, int pagesize) throws Exception{
	         
			CustomerPage page=customerService.getPage1(pageno, pagesize);
	                 
			 return page; 
		}
		
		@RequestMapping(value="/getCount.action",method= {RequestMethod.POST,RequestMethod.GET})
		public @ResponseBody int getCount() throws Exception{
	         
	         int count=customerService.getTotal();
	                 
			 return count; 
		}
	    
		
		@RequestMapping(value="/ByKfid.action",method= {RequestMethod.POST,RequestMethod.GET})
		public @ResponseBody  CustomerPage ByKfid( int pageno, int pagesize,String kid) throws Exception{
	         
			CustomerPage page=customerService.findByKFid(pageno, pagesize, kid);
	                 
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
		public  @ResponseBody void  test3(HttpServletRequest req,HttpServletResponse res,Customer customer){
			try {
				req.setCharacterEncoding("utf-8");
				res.setCharacterEncoding("utf-8");
				res.setContentType("text/html; charset=utf-8");

			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			System.out.println(customer.getKname());
			customerService.insert(customer);
			   
				
		}
		
		
		@RequestMapping(value="/updateCustomer.action",method={RequestMethod.GET,RequestMethod.POST})
		public @ResponseBody Customer test4(String s) throws UnsupportedEncodingException {
			   int kid=Integer.parseInt(s);
			   Customer customer=customerService.findById(kid);
			   return customer; 
		}
   
		@RequestMapping(value="/delete.action",method={RequestMethod.GET,RequestMethod.POST})
		public  @ResponseBody void  delete(String s) {
		    
			String [] a=s.split(",");
		     int [] d =new int[a.length];
		     for(int i=0;i<a.length;i++) {
		    	 d[i]=Integer.parseInt(a[i]);
		     }
		     customerService.deleteByArray(d);
	        
		}
		
		@RequestMapping(value="/saveCustomer.action",method={RequestMethod.GET,RequestMethod.POST})
		public  @ResponseBody String test6(Customer customer,String id) {
	         if(id.equals("")) {	        	 
	        	 customerService.insert(customer);
				 return "insert succeed";
			 }
			 else if(!id.equals("")){
				 customer.setKid(Integer.parseInt(id));
				 customerService.update(customer);
				 return "update succeed";
			 }else {
				 return "false";
			 }

		}
	  
		@RequestMapping(value="/findByKname.action",method={RequestMethod.GET,RequestMethod.POST})
		public @ResponseBody Customer test7(String s) throws UnsupportedEncodingException {
			
			Customer customer=customerService.findByKName(s);
				return customer;
			
	          
		}
		@RequestMapping(value="/findByKid.action",method={RequestMethod.GET,RequestMethod.POST})
		public @ResponseBody Customer test8(int kid) throws UnsupportedEncodingException {	     
			Customer customer=customerService.findById(kid);
			//customer.setKarea(customerService.findById2(Integer.parseInt(customer.getKarea())).getName());
				return customer;   
		}
		
		
		@RequestMapping(value="/zhuanyi.action",method={RequestMethod.GET,RequestMethod.POST})
		public @ResponseBody String zhuanyi(int kid) throws UnsupportedEncodingException {	     
			Customer customer=customerService.findById(kid);
			CustomerSea cusSea=new CustomerSea();
			cusSea.setKarea(customer.getKarea());
			cusSea.setKdegree(customer.getKdegree());
			cusSea.setKdept(customer.getKdept());
			cusSea.setKemail(customer.getKemail());
			cusSea.setKfid(customer.getKfid());
			cusSea.setKname(customer.getKname());
			cusSea.setKnext(customer.getKnext());
			cusSea.setKphone(customer.getKphone());
			cusSea.setKremark(customer.getKremark());
			cusSea.setKsize(customer.getKsize());
			cusSea.setKsource(customer.getKsource());
			cusSea.setKstatus(customer.getKstatus());
			cusSea.setKtrade(customer.getKtrade());
			cusSea.setKzip(customer.getKzip());
			cusSea.setKrecord(customer.getKrecord());
			cusSea.setKactual(customer.getKactual());
			try {
				int [] a= {kid};
				customerService.deleteByArray(a);
				sea.insert(cusSea);
				
				return "succeed";   
			}catch(Exception e) {
				System.out.println("false");
				return "false";   
			}
				
		}
}

