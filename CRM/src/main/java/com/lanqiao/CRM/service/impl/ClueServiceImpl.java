package com.lanqiao.CRM.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.ClueDao;
import com.lanqiao.CRM.entity.Area;
import com.lanqiao.CRM.entity.Clue;
import com.lanqiao.CRM.service.ClueService;
import com.lanqiao.CRM.utils.PageUtil;


@Service
public class ClueServiceImpl implements ClueService{
	@Autowired
    private ClueDao  clueDao;

	
	public void setClueDao(ClueDao clueDao) {
		this.clueDao = clueDao;
	}

	@Override
	public List<Clue> findAll() {
		
		return clueDao.findAll();
	}

	@Override
	public Clue findById(int id) {
		// TODO Auto-generated method stub
		return clueDao.findById(id);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return clueDao.getTotal();
	}

	@Override
	public PageUtil getPage1(int pageno, int pagesize) {
		Map<String,Integer> map=new HashMap<String,Integer>();
        PageUtil  page=new PageUtil();
        
		int total=clueDao.getTotal();
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);

		List list=clueDao.getPage(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public void insert(Clue clue) {
		
		clueDao.insert(clue);
		
	}

	@Override
	public void update(Clue clue) {
		// TODO Auto-generated method stub
		clueDao.update(clue);
	}

	@Override
	public Clue findByXName(String xname) {
		// TODO Auto-generated method stub
		return clueDao.findByXName(xname);
	}

	
	@Override
	public void deleteByArray(int[] xid) {
		// TODO Auto-generated method stub
		clueDao.deleteByArray(xid);
	}

	@Override
	public PageUtil findByXFid(int pageno, int pagesize,String xfid) {
		Map<Object,Object> map=new HashMap<Object,Object>();
        PageUtil  page=new PageUtil();
        
		int total=clueDao.getTotalByXfid(xfid);
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);
		map.put("xfid", xfid);

		List list=clueDao.findByXFid(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public int getTotalByXfid(String xfid) {
		
		return clueDao.getTotalByXfid(xfid);
	}

	@Override
	public Area findById2(int id) {
		// TODO Auto-generated method stub
		return clueDao.findById2(id);
	}

	@Override
	public PageUtil findBySome(int pageno, int pagesize, Clue clue) {
		
		Map<String,Object> map=new HashMap<String,Object>();
        PageUtil  page=new PageUtil();
        
		int total=clueDao.getTotalBySome(clue);
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}
		if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);
		map.put("clue", clue);

		List list=clueDao.findBySome(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
		
	}

	

}
