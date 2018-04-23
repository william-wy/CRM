package com.lanqiao.CRM.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.ChanceDao;

import com.lanqiao.CRM.entity.Area;
import com.lanqiao.CRM.entity.Chance;

import com.lanqiao.CRM.service.ChanceService;
import com.lanqiao.CRM.utils.ChancePageUtil;



@Service
public class ChanceServiceImpl implements ChanceService{
	@Autowired
    private ChanceDao  chanceDao;

	public void setChanceDao (ChanceDao chanceDao) {
		this.chanceDao =chanceDao;
	}

	@Override
	public List<Chance> findAll() {
		
		return chanceDao.findAll();
	}

	@Override
	public Chance findById(int id) {
		// TODO Auto-generated method stub
		return chanceDao.findById(id);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return chanceDao.getTotal();
	}

	@Override
	public ChancePageUtil getPage1(int pageno, int pagesize) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		ChancePageUtil  page=new ChancePageUtil();
        
		int total=chanceDao.getTotal();
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);

		List list=chanceDao.getPage(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public void insert(Chance chance) {
		System.out.println(chance);
		chanceDao.insert(chance);
		
	}

	@Override
	public void update(Chance chance) {
		// TODO Auto-generated method stub
		chanceDao.update(chance);
	}

	@Override
	public Chance findByJname(String jname) {
		// TODO Auto-generated method stub
		return chanceDao.findByJname(jname);
	}

	
	@Override
	public void deleteByArray(int[] jid) {
		// TODO Auto-generated method stub
		chanceDao.deleteByArray(jid);
	}

	@Override
	public ChancePageUtil findByJdept(int pageno, int pagesize,String jdept){
		Map<Object,Object> map=new HashMap<Object,Object>();
		ChancePageUtil  page=new ChancePageUtil();
        
		int total=chanceDao.getTotalByJdept(jdept);
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);
		map.put("jdept",jdept);

		List list=chanceDao.findByJdept(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public int getTotalByJdept(String jdept) {
		
		return chanceDao.getTotalByJdept(jdept);
	}
	@Override
	public Area findById2(int id) {
		// TODO Auto-generated method stub
		return chanceDao.findById2(id);
	}

}
