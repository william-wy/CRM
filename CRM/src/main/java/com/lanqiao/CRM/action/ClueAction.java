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
import com.lanqiao.CRM.service.ClueService;
import com.lanqiao.CRM.utils.PageUtil;


@Controller
@RequestMapping("/clue")
public class ClueAction {
     @Autowired
	 private ClueService clueService;
     
     String[] some=new String[7];


	@RequestMapping(value="/all.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody  PageUtil test2( int pageno, int pagesize) throws Exception{
         
         PageUtil page=clueService.getPage1(pageno, pagesize);
                 
		 return page; 
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
	public @ResponseBody  PageUtil findBySome(int pageno,int pagesize,String xszt,String dq,String sjgj,String xcgj,String fzr,String ssbm,String ssly) throws Exception{
         
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
		if(fzr!=null&&!fzr.equals("")) {
			if(fzr.equals("all")) {
				some[4]=null;
			}else {
				some[4]=fzr;
			}
		}
		if(ssbm!=null&&!ssbm.equals("")) {
			if(ssbm.equals("all")) {
				some[5]=null;
			}else {
				some[5]=ssbm;
			}
		}
		if(ssly!=null&&!ssly.equals("")) {
			if(ssly.equals("all")) {
				some[6]=null;
			}else {
				some[6]=ssly;
			}
		}
		
		Clue clue=new Clue();
		clue.setXstatus(some[0]);
		clue.setXarea(some[1]);
		clue.setXactual(some[2]);
		clue.setXnext(some[3]);
		clue.setXfid(some[4]);
		clue.setXdeptno(some[5]);
		clue.setXsource(some[6]);
		
		for(String s:some) {
			System.out.println(s);
		}
		
         PageUtil page=clueService.findBySome(pageno, pagesize, clue);
                 
		 return page; 
	}
	
}
