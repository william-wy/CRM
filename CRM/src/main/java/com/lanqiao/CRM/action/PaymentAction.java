package com.lanqiao.CRM.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.CRM.entity.Billrecord;
import com.lanqiao.CRM.entity.Clue;
import com.lanqiao.CRM.entity.PayPlan;
import com.lanqiao.CRM.entity.PayRecord;
import com.lanqiao.CRM.service.BillRecordService;
import com.lanqiao.CRM.service.PayPlanService;
import com.lanqiao.CRM.service.PayRecordService;
import com.lanqiao.CRM.utils.PageUtil;
import com.lanqiao.CRM.utils.PageUtilBillRecord;
import com.lanqiao.CRM.utils.PageUtilPayPlan;
import com.lanqiao.CRM.utils.PageUtilPayRecord;

@Controller
@RequestMapping("/payment")
public class PaymentAction {
	@Autowired
	private PayPlanService payPlanService;
	@Autowired
	private PayRecordService payRecordService;
	@Autowired
	private BillRecordService billRecordService;
	
	@RequestMapping(value="/all.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody  PageUtilPayPlan test4(int pageno,int pagesize) throws Exception{
         
         PageUtilPayPlan page=payPlanService.getPage1(pageno, pagesize);
                 
		 return page; 
	}
	
	@RequestMapping(value="/findByPaydate.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody  PageUtilPayRecord findByPaydate(int pageno,int pagesize,String date) throws Exception{
		PageUtilPayRecord page=null;
		
		if(date.equals("quanbu")) {
        	 page=payRecordService.getPage1(pageno, pagesize);
        	 
         }else if(date.equals("today")) {
        	 //PageUtilPayRecord page=payRecordService.findByPaydate(pageno, pagesize,"  ");
        	 SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
        	 String paydate=simpleDateFormat.format(new Date());
        	page=payRecordService.findByPaydate(pageno, pagesize, paydate);
        	 
         }
		   return page;
	}
	
	
	@RequestMapping(value="/allpayplan.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody  PageUtilPayPlan test1(int pageno,int pagesize) throws Exception{
         
         PageUtilPayPlan page=payPlanService.getPage1(pageno, pagesize);
                 
		 return page; 
	}
	
	@RequestMapping(value="/allpayrecord.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody  PageUtilPayRecord test2(int pageno,int pagesize) throws Exception{
         
		PageUtilPayRecord page=payRecordService.getPage1(pageno, pagesize);
                 
		 return page; 
	}
	
	@RequestMapping(value="/allbillrecord.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody  PageUtilBillRecord test3(int pageno,int pagesize) throws Exception{
         
		PageUtilBillRecord page=billRecordService.getPage1(pageno,pagesize);
                 
		 return page; 
	}
	
	
	@RequestMapping(value="/deletepayplan.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody String  delete(String s) {
		if(s.equals("")) {
			 return "false";
		}else {
	     String [] a=s.split(",");
	     
	     int [] d =new int[a.length];
	     for(int i=0;i<a.length;i++) {
	    	 d[i]=Integer.parseInt(a[i]);
	     }
	     payPlanService.deleteByArray(d);
	     return "delete succeed";
		}
	}
	
	
	@RequestMapping(value="/deletepayrecord.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody String  deletepayrecord(String s) {
		if(s.equals("")) {
			 return "false";
		}else {
	     String [] a=s.split(",");
	     
	     int [] d =new int[a.length];
	     for(int i=0;i<a.length;i++) {
	    	 d[i]=Integer.parseInt(a[i]);
	     }
	     payRecordService.deleteByArray(d);
	     return "delete succeed";
		}
	}
	
	@RequestMapping(value="/deletebillrecord.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody String  deletebillrecord(String s) {
		if(s.equals("")) {
			 return "false";
		}else {
	     String [] a=s.split(",");
	     
	     int [] d =new int[a.length];
	     for(int i=0;i<a.length;i++) {
	    	 d[i]=Integer.parseInt(a[i]);
	     }
	     billRecordService.deleteByArray(d);
	     return "delete succeed";
		}
	}
	
	@RequestMapping(value="/savePayPlan.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody String savePayPlan(PayPlan payPlan,HttpServletRequest req,HttpServletResponse res) {
		try {
			req.setCharacterEncoding("utf-8");
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html; charset=utf-8");
            
			 payPlanService.insert(payPlan);
			 return "insert succeed";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			  return "false";
		}
	}
	
	@RequestMapping(value="/savePayRecord.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody String savePayRecord(PayRecord payRecord,HttpServletRequest req,HttpServletResponse res) {
		try {
			req.setCharacterEncoding("utf-8");
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html; charset=utf-8");
            
			payRecordService.insert(payRecord);
			 return "insert succeed";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			  return "false";
		}
	}
	
	@RequestMapping(value="/saveBillRecord.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody String saveBillRecord(Billrecord billRecord,HttpServletRequest req,HttpServletResponse res) {
		try {
			req.setCharacterEncoding("utf-8");
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html; charset=utf-8");
            
			 billRecordService.insert(billRecord);
			 return "insert succeed";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			  return "false";
		}
	}
	
	@RequestMapping(value="/findById.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List findById(int id) {
		int payTotal=0;
		PayRecord payRecord=payRecordService.findById(id);
		PayPlan payPlan=payPlanService.findByCusAndHeTong(payRecord.getCustomer(), payRecord.getContract());
		List<PayRecord> list1=payRecordService.findByCusAndHetong(payRecord.getCustomer(), payRecord.getContract());
		for(int i=0;i<list1.size();i++) {
			payTotal+=list1.get(i).getPaymoney();
		}
		List <Object> list=new ArrayList<Object>();
		list.add(payRecord);
		list.add(payPlan);
		list.add(payTotal);
		return list;

	}
	
	
	
}
