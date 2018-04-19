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
			return clue;   
	}
	
	@RequestMapping(value="/findByXid.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Clue test8(int xid) throws UnsupportedEncodingException {
		    
		     
			Clue clue=clueService.findById(xid);
			clue.setXarea(clueService.findById2(Integer.parseInt(clue.getXarea())).getName());
			return clue;   
	}
	
}
