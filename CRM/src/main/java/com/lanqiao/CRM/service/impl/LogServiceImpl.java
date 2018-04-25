package com.lanqiao.CRM.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.LogDao;
import com.lanqiao.CRM.entity.Log;
import com.lanqiao.CRM.service.LogService;
import com.lanqiao.CRM.utils.PageUtil;

@Service
public class LogServiceImpl implements LogService{
	@Autowired
   private LogDao logDao;
	
	
	
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}

	@Override
	public List findAll(String s) {
		
		List list=logDao.findAll(s);
	    
		

		return list;
	}

	@Override
	public int getTotal(String s) {
		// TODO Auto-generated method stub
		return logDao.getTotal(s);
	}

}
