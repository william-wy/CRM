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
import com.lanqiao.CRM.service.ClueService;
import com.lanqiao.CRM.utils.PageUtil;

@Controller
@RequestMapping("/clue")
public class ClueAction {
	
    @Autowired
	private ClueService clueService;

	@RequestMapping(value="/getClueList.action")
	public @ResponseBody List<Clue> getClueList() throws Exception {
		
		List<Clue> cluelist=clueService.findAll();
		
		
		return cluelist;
	}
	
	@RequestMapping("/ajax.action")
	public @ResponseBody Clue test1() throws Exception {
	
		   Clue clue=clueService.findById(2);
           
		 return clue;
	}
	
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
	@RequestMapping(value="/addClue.action",method= {RequestMethod.POST,RequestMethod.GET})
	/**
	 * 提交表单用post， 表单属性在加一个 enctype="multipart/form-data"
	 * 直接自动绑定表单中与clue属性相同的
	 * ajax中如果用get方法提交，写data{xid:xid},
	 *      如果用post方法提交则直接在URL后面跟参数        url:'/ssm06/clue/deleteClue.action?xid='+xid,
	 *      然后action中的请求方法要一致
	 */
	public  @ResponseBody void  test3(HttpServletRequest req,HttpServletResponse res,Clue clue){
		try {
			req.setCharacterEncoding("utf-8");
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html; charset=utf-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		System.out.println(clue.getXname());
		clueService.insert(clue);
		   
			
	}
	
	
	@RequestMapping(value="/updateClue.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Clue test4(String s) throws UnsupportedEncodingException {
		   int xid=Integer.parseInt(s);
		   Clue clue=clueService.findById(xid);
		   
		   return clue; 
	}
	

	
   
	@RequestMapping(value="/delete.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody void  delete(String s) {
	     String [] a=s.split(",");
	     System.out.println(a[1]);
	     int [] d =new int[a.length];
	     for(int i=0;i<a.length;i++) {
	    	 d[i]=Integer.parseInt(a[i]);
	     }
	     clueService.deleteByArray(d);
        
	}
	
	@RequestMapping(value="/saveClue.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody String test6(Clue clue,String id) {
	     
	     
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
	public @ResponseBody Clue test7(String s) throws UnsupportedEncodingException {
		
			Clue clue=clueService.findByXName(s);
			return clue;
		
          
	}
}
