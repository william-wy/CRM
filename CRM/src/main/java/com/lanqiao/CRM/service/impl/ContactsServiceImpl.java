package com.lanqiao.CRM.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.ContactsDao;
import com.lanqiao.CRM.entity.Area;

import com.lanqiao.CRM.entity.Contacts;
import com.lanqiao.CRM.service.ContactsService;
import com.lanqiao.CRM.utils.ContactsPageUtil;




@Service
public class ContactsServiceImpl implements ContactsService{
	@Autowired
    private ContactsDao contactsDao;
	
	public void setContactsDao (ContactsDao  contactsDao) {
		this.contactsDao =contactsDao;
	}

	@Override
	public List<Contacts> findAll() {
		
		return contactsDao.findAll();
	}

	@Override
	public Contacts findById(int id) {
		// TODO Auto-generated method stub
		return contactsDao.findById(id);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return contactsDao.getTotal();
	}

	@Override
	public ContactsPageUtil getPage1(int pageno, int pagesize) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		ContactsPageUtil  page=new ContactsPageUtil();
        
		int total=contactsDao.getTotal();
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);

		List list=contactsDao.getPage(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public void insert(Contacts contacts) {
		System.out.println(contacts);
		contactsDao.insert(contacts);
		
	}

	@Override
	public void update(Contacts contacts) {
		// TODO Auto-generated method stub
		contactsDao.update(contacts);
	}

	@Override
	public Contacts findByL_Name(String l_name) {
		// TODO Auto-generated method stub
		return contactsDao.findByL_Name(l_name);
	}

	
	@Override
	public void deleteByArray(int[] l_id) {
		// TODO Auto-generated method stub
		contactsDao.deleteByArray(l_id);
	}

	@Override
	public ContactsPageUtil findByL_fdeptno(int pageno, int pagesize,String l_fdeptno){
		Map<Object,Object> map=new HashMap<Object,Object>();
		ContactsPageUtil  page=new ContactsPageUtil();
        
		int total=contactsDao.getTotalByL_fdeptno(l_fdeptno);
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);
		map.put("l_fdeptno",l_fdeptno);

		List list=contactsDao.findByL_fdeptno(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public int getTotalByL_fdeptno(String l_fdeptno) {
		
		return contactsDao.getTotalByL_fdeptno(l_fdeptno);
	}
	@Override
	public Area findById2(int id) {
		// TODO Auto-generated method stub
		return contactsDao.findById2(id);
	}

	@Override
	public ContactsPageUtil findBySome(int pageno, int pagesize, Contacts contacts) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		ContactsPageUtil  page=new ContactsPageUtil();
        
		int total=contactsDao.getTotalBySome(contacts);
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}
		if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);
		map.put("contacts", contacts);

		List list=contactsDao.findBySome(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
		
	}
	
}
