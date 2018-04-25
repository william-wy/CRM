package com.lanqiao.CRM.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.CountDao;
import com.lanqiao.CRM.entity.ChanPin;
import com.lanqiao.CRM.entity.GenJinCiShu;
import com.lanqiao.CRM.entity.HeTong;
import com.lanqiao.CRM.entity.HuiKuanJiHua;
import com.lanqiao.CRM.service.CountService;

@Service
	public class CountServiceImpl implements CountService{
	    @Autowired
	    private CountDao countdao;
	    @Override
		public List<HeTong> countcontract() {
	    	
			return countdao.countcontract();
		}
		@Override
		public List<HuiKuanJiHua> countpayplan() {
			// TODO Auto-generated method stub
			return countdao.countpayplan();
		}
		@Override
		public List<ChanPin> countproduct() {
			
		    
			return countdao.countproduct();
		}
		@Override
		public List<GenJinCiShu> counttime() {
			// TODO Auto-generated method stub
			return countdao.counttime();
		}
	  
	}


