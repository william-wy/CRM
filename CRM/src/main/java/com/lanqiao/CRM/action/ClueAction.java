package com.lanqiao.CRM.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.CRM.entity.Clue;
import com.lanqiao.CRM.entity.Customer;
import com.lanqiao.CRM.service.ClueService;
import com.lanqiao.CRM.service.CustomerService;
import com.lanqiao.CRM.utils.PageUtil;


@Controller
@RequestMapping("/clue")
public class ClueAction {
     @Autowired
	 private ClueService clueService;
     
     @Autowired
	 private CustomerService customerService;
     
     String[] some=new String[7];


	@RequestMapping(value="/all.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody  PageUtil test2( int pageno, int pagesize) throws Exception{
         
         PageUtil page=clueService.getPage1(pageno, pagesize);
                 
		 return page; 
	}
	
	@RequestMapping(value="/getCount.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody int getCount() throws Exception{
         
         int count=clueService.getTotal();
                 
		 return count; 
	}
	
	@RequestMapping(value="/ByXfid.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody  PageUtil ByXfid( int pageno, int pagesize,String fid) throws Exception{
         
         PageUtil page=clueService.findByXFid(pageno, pagesize, fid);
              
		 return page; 
	}
	
	@RequestMapping(value="/updateClue.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Clue test4(String s,HttpServletRequest req,HttpServletResponse res) throws UnsupportedEncodingException {
		try {
			req.setCharacterEncoding("utf-8");
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html; charset=utf-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   int xid=Integer.parseInt(s);
		   Clue clue=clueService.findById(xid);
		  
		   return clue; 
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
	     clueService.deleteByArray(d);
	     return "delete succeed";
		}
	}
	
	@RequestMapping(value="/saveClue.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody String test6(Clue clue,String id,HttpServletRequest req,HttpServletResponse res) {
		try {
			req.setCharacterEncoding("utf-8");
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html; charset=utf-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
         if(id.equals("")) {
			 clueService.insert(clue);
			 return "insert succeed";
		 }
		 else if(!id.equals("")){
			 clue.setXid(Integer.parseInt(id));
			 clueService.update(clue);
			 return "update succeed";
		 }else {
			 return "false";
		 }
	}
  
	@RequestMapping(value="/findByXname.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Clue test7(String s)throws UnsupportedEncodingException {
			Clue clue=clueService.findByXName(s);
			clue.setXarea(clueService.findById2(Integer.parseInt(clue.getXarea())).getName());
			return clue;   
	}
	
	@RequestMapping(value="/findByXid.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Clue test8(int xid) throws UnsupportedEncodingException {
		    
		     
			Clue clue=clueService.findById(xid);
			clue.setXarea(clueService.findById2(Integer.parseInt(clue.getXarea())).getName());
			return clue;   
	}
	
	@RequestMapping(value="/findBySome.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody  PageUtil findBySome(int pageno,int pagesize,String xszt,String dq,String sjgj,String xcgj,String xsly,String name,String gsmc) throws Exception{
         
		if(xszt!=null&&!xszt.equals("")) {
			if(xszt.equals("all")) {
				some[0]=null;
			}else {
				some[0]=xszt;
			}
		}
		if(dq!=null&&!dq.equals("")) {
			if(dq.equals("all")) {
				some[1]=null;
			}else {
				some[1]=dq;
			}
		}
		if(sjgj!=null&&!sjgj.equals("")) {
			if(sjgj.equals("all")) {
				some[2]=null;
			}else {
				some[2]=sjgj;
			}
		}
		if(xcgj!=null&&!xcgj.equals("")) {
			if(xcgj.equals("all")) {
				some[3]=null;
			}else {
				some[3]=xcgj;
			}
		}
		if(xsly!=null&&!xsly.equals("")) {
			if(xsly.equals("all")) {
				some[4]=null;
			}else {
				some[4]=xsly;
			}
		}
		if(name!=null&&!name.equals("")) {
			if(name.equals("all")) {
				some[5]=null;
			}else {
				some[5]=name;
			}
		}
		if(gsmc!=null&&!gsmc.equals("")) {
			if(gsmc.equals("all")) {
				some[6]=null;
			}else {
				some[6]=gsmc;
			}
		}
		
		Clue clue=new Clue();
		clue.setXstatus(some[0]);
		clue.setXarea(some[1]);
		clue.setXactual(some[2]);
		clue.setXnext(some[3]);
		clue.setXsource(some[4]);
		clue.setXname(some[5]);
		clue.setXcomname(some[6]);
		
		for(String s:some) {
			System.out.println(s);
		}
		
         PageUtil page=clueService.findBySome(pageno, pagesize, clue);
                 
		 return page; 
	}
	
	
	
	@RequestMapping(value="/zhuanyi.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String zhuanyi(int kid,String jibie,String hangye,String guimo,String genjinrecord) throws UnsupportedEncodingException {	
		System.out.println(jibie+"jibie"+hangye+" hangye "+guimo+"guimo  "+genjinrecord+" genjinrecord ");
		Clue  clue=clueService.findById(kid);
		
		Customer customer=new Customer();
		
		try {
			int [] a= {kid};
			customer.setKactual(clue.getXactual());
			customer.setKarea(clue.getXarea());
			customer.setKdegree(jibie);
			customer.setKdept(clue.getXdeptno());
			customer.setKemail(clue.getXemail());
			customer.setKfid(clue.getXfid());
			customer.setKname(clue.getXname());
			customer.setKnext(clue.getXnext());
			customer.setKphone(clue.getXphone());
			customer.setKrecord(genjinrecord);
			customer.setKremark(clue.getXremark());
			customer.setKsize(guimo);
			customer.setKsource(clue.getXsource());
			customer.setKstatus(clue.getXstatus());
			customer.setKtrade(hangye);
			customer.setKzip(clue.getXzip());
			clueService.deleteByArray(a);
			customerService.insert(customer);
			return "succeed";   
		}catch(Exception e) {
			
			System.out.println("false");
			return "false";   
		}
			
	}
	
}
