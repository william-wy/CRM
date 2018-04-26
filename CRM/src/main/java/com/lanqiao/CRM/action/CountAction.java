package com.lanqiao.CRM.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.CRM.entity.ChanPin;
import com.lanqiao.CRM.entity.GenJinCiShu;
import com.lanqiao.CRM.entity.HeTong;
import com.lanqiao.CRM.entity.HuiKuanJiHua;
import com.lanqiao.CRM.service.CountService;

@Controller
@RequestMapping(value = "/echarts")
public class CountAction {
@Autowired
private CountService countService;
    @RequestMapping(value = "/countcontract")
    public @ResponseBody  Object getCountContract(){
        List<HeTong> list=countService.countcontract();
            return list;
    }
    @RequestMapping(value = "/countpayplan")
    public @ResponseBody  Object getCountPayplan(){
        List<HuiKuanJiHua> list=countService.countpayplan();
            return list;
    }
    @RequestMapping(value = "/countproduct")
    public @ResponseBody  Object getCountProduct(){
        List<ChanPin> list=countService.countproduct();
        
            return list;
    }
    @RequestMapping(value = "/counttime")
    public @ResponseBody  Object getCountTime(){
        List<GenJinCiShu> list=countService.counttime();
       List<GenJinCiShu> list1=new ArrayList<>();
       
        list1.add(list.get(28));
       
        list1.add(list.get(30));
        list1.add(list.get(32));
        list1.add(list.get(36));
        
            return list1;
    }
}