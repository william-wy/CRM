package com.lanqiao.CRM.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.CRM.entity.PICharge;
import com.lanqiao.CRM.service.PICService;

@Controller
public class PIChargeAction {	
	@Autowired
	private PICService service ;
	public void setService(PICService service) {
		this.service = service;
	}
	@RequestMapping("/index.action")
	public String goindex(){
		return "index";
	}
	@RequestMapping("/getname.action")
	public @ResponseBody PICharge  getname(HttpSession session){
		 PICharge  pic=(PICharge) session.getAttribute("PICharge");
		 System.out.println(pic);
		return pic;
		
	}
	@RequestMapping("/byebye.action")
	public @ResponseBody PICharge  bye(HttpSession session){
		 PICharge  pic=null;
				  session.setAttribute("PICharge",pic);
		 System.out.println(pic);
		return pic;
		
	}
	@RequestMapping("/PIClogin.action")
	public @ResponseBody String PIClogin(String username,String password,HttpSession session){
	
		try {
			PICharge pc= service.login(username, password);
			System.out.println(username);
			System.out.println(password);
			session.setAttribute("PICharge", pc);
			System.out.println(pc);
			if (pc!=null) {
				return "index";
			}else{
				return "error";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	
		
	}
	@RequestMapping("/PICregister.action")
	public @ResponseBody String register(PICharge PIC){
		int i =-1;
		try {
			i=service.save(PIC);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i<0) {
			return "error";
		}else{
			return "success";

		}
	}
	@RequestMapping("/random.action")  
    public @ResponseBody String findRandom (HttpServletResponse response) throws IOException{  
         // 验证码字符个数        
         int codeCount = 4;  
         char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',        
                    'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',        
                    'X', 'Y', 'Z','a','b','c','d','e','f','g','h','i','j','k',
                    'l','m','n','o','p','q','r','s','t','u','v','s','x','y','z',
                    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };  
           
         // 创建一个随机数生成器类        
            Random random = new Random(); 
            
         // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。        
            StringBuffer randomCode = new StringBuffer();  
            for (int i = 0; i < codeCount; i++) {        
                // 得到随机产生的验证码数字。        
                String strRand = String.valueOf(codeSequence[random.nextInt(62)]);    
                // 将产生的四个随机数组合在一起。        
                 randomCode.append(strRand);        
            }  
            return  randomCode.toString();
             
    } 
	
}
