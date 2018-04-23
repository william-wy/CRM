package com.lanqiao.CRM.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.JurUtilDao;
import com.lanqiao.CRM.entity.Area;
import com.lanqiao.CRM.entity.Jur;
import com.lanqiao.CRM.entity.PICharge;
import com.lanqiao.CRM.entity.RoleUser;
import com.lanqiao.CRM.service.JurUtilService;
import com.lanqiao.CRM.utils.PageUtil;
@Service
public class JurUtilServiceImpl implements JurUtilService{
	@Autowired
	private JurUtilDao jurUtilDao;

	public void setJurUtilDao(JurUtilDao jurUtilDao) {
		this.jurUtilDao = jurUtilDao;
	}


	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return jurUtilDao.getTotal();
	}

	@Override
	public PageUtil getPage1(int pageno, int pagesize) {
		// TODO Auto-generated method stub
		Map<String,Integer> map=new HashMap<String,Integer>();
        PageUtil  page=new PageUtil();
        
		int total=jurUtilDao.getTotal();
	
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);

		List list=jurUtilDao.getPage(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public void insert(Jur jur) {
		// TODO Auto-generated method stub
		jurUtilDao.insert(jur);
	}

	@Override
	public void update(Jur jur) {
		// TODO Auto-generated method stub
		jurUtilDao.update(jur);
	}


	@Override
	public Jur findById(int id) {
		// TODO Auto-generated method stub
		return jurUtilDao.findById(id);
	}


	@Override
	public void update2(RoleUser roleUser) {
		
		jurUtilDao.update2(roleUser);
		
	}	
}
