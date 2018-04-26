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

import com.lanqiao.CRM.entity.Chance;
import com.lanqiao.CRM.entity.Contract;
import com.lanqiao.CRM.service.ChanceService;
import com.lanqiao.CRM.service.ContractService;
import com.lanqiao.CRM.utils.ChancePageUtil;


@Controller
@RequestMapping("/chance")
public class ChanceAction {
	
    @Autowired
	private ChanceService chanceService;
    @Autowired
    private ContractService contractService;

	public void setChanceService(ChanceService chanceService) {
		this.chanceService = chanceService;
	}

	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}

	@RequestMapping(value="/getChanceList.action")
	public @ResponseBody List<Chance> getChanceList() throws Exception {
		
		List<Chance> chancelist=chanceService.findAll();
		
		
		return chancelist;
	}
	
	@RequestMapping("/ajax.action")
	public @ResponseBody Chance test1() throws Exception {
	
		Chance chance=chanceService.findById(2);
           
		 return chance;
	}
	
	@RequestMapping(value="/all.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody  ChancePageUtil test2( int pageno, int pagesize) throws Exception{
         
		ChancePageUtil page=chanceService.getPage1(pageno, pagesize);
                 
		 return page; 
	}
	
	@RequestMapping(value="/getCount.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody int getCount() throws Exception{
         
         int count=chanceService.getTotal();
                 
		 return count; 
	}
    
	
	@RequestMapping(value="/ByJdept.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody  ChancePageUtil ByJdept( int pageno, int pagesize,String fid) throws Exception{
         
		ChancePageUtil page=chanceService.findByJdept(pageno, pagesize, fid);
                 
		 return page; 
	}
	@RequestMapping(value="/addChance.action",method= {RequestMethod.POST,RequestMethod.GET})
	/**
	 * 提交表单用post， 表单属性在加一个 enctype="multipart/form-data"
	 * 直接自动绑定表单中与clue属性相同的
	 * ajax中如果用get方法提交，写data{xid:xid},
	 *      如果用post方法提交则直接在URL后面跟参数        url:'/ssm06/clue/deleteClue.action?xid='+xid,
	 *      然后action中的请求方法要一致
	 */
	public  @ResponseBody void  test3(HttpServletRequest req,HttpServletResponse res,Chance chance){
		try {
			req.setCharacterEncoding("utf-8");
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html; charset=utf-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		chanceService.insert(chance);
		   
			
	}
	
	
	@RequestMapping(value="/updateChance.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Chance test4(String s) throws UnsupportedEncodingException {
		   int jid=Integer.parseInt(s);
		   Chance chance=chanceService.findById(jid);
		   
		   return chance; 
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
	     chanceService.deleteByArray(d);
	     return "delete succeed";
		}
	}
	
	@RequestMapping(value="/saveChance.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody String test6(Chance chance,String id) {
	     
	    
         if(id.equals("")) {
        	 System.out.println("============");
     		System.out.println("============");
     		System.out.println(chance.getJdonetime());
     		System.out.println("============");
        	 
        	 chanceService.insert(chance);
			 return "insert succeed";
		 }
		 else if(!id.equals("")){
			 chance.setJid(Integer.parseInt(id));
			 chanceService.update(chance);
			 return "update succeed";
		 }else {
			 return "false";
		 }

	}
  
	@RequestMapping(value="/findByJname.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Chance test7(String s) throws UnsupportedEncodingException {
		
		Chance chance=chanceService.findByJname(s);
			return chance;     
	}
	@RequestMapping(value="/findByJid.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Chance test8(int jid) throws UnsupportedEncodingException {
		    
		     System.out.println(jid);
		Chance chance=chanceService.findById(jid);
		
			return chance;   
	}
	@RequestMapping(value="/zhuanyi.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String zhuanyi(int kid,Contract contract) throws UnsupportedEncodingException {	
		
		   Chance chance=chanceService.findById(kid);
		   
		   
		try {
			int [] a= {kid};
			contract.setHname(chance.getJname());
			contract.setHclient_name(chance.getJclient());
			chanceService.deleteByArray(a);
			contractService.save(contract);
			return "succeed";   
		}catch(Exception e) {
			
			System.out.println("false");
			return "false";   
		}
			
	}
	
}