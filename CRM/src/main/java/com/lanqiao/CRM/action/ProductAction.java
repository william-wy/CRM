package com.lanqiao.CRM.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.CRM.entity.Product;
import com.lanqiao.CRM.service.ProductService;
import com.lanqiao.CRM.utils.PageUtil;


@Controller
@RequestMapping("/product")
public class ProductAction {
	@Autowired
      private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value="/all.action",method= {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody  PageUtil test2( int pageno, int pagesize) throws Exception{
         
         PageUtil page=productService.getPage(pageno, pagesize);
                 
		 return page; 
	}
	
	
	@RequestMapping(value="/delete.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody void  delete(String s) {
		if(s.equals("")) {
			   
		}else {
	     String [] a=s.split(",");
	     
	     int [] d =new int[a.length];
	     for(int i=0;i<a.length;i++) {
	    	 d[i]=Integer.parseInt(a[i]);
	     }
	     productService.deleteByArray(d);
		}
	}
	
	@RequestMapping(value="/updateProduct.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Product test4(String s,HttpServletRequest req,HttpServletResponse res) throws UnsupportedEncodingException {
		if(s==null|s.equals("")) {
			return null;
		}else {
		   int pid=Integer.parseInt(s);
		   Product p=productService.findByPid(pid);
		   
		   return p; 
		   }
	}
	
	@RequestMapping(value="/saveProduct.action",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody String test6(Product product,String id,HttpServletRequest req,HttpServletResponse res) {
		try {
			req.setCharacterEncoding("utf-8");
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/html; charset=utf-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         if(id.equals("")) {
        	 productService.insert(product);
			 return "insert succeed";
		 }
		 else if(!id.equals("")){
			 product.setPid(Integer.parseInt(id));
			 productService.update(product);
			 return "update succeed";
		 }else {
			 return "false";
		 }
	}
}
