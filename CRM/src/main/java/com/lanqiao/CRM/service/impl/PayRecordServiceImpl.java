package com.lanqiao.CRM.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.PayRecordDao;
import com.lanqiao.CRM.entity.PayRecord;
import com.lanqiao.CRM.service.PayRecordService;

import com.lanqiao.CRM.utils.PageUtilPayRecord;

@Service
public class PayRecordServiceImpl implements PayRecordService{
     @Autowired
	private PayRecordDao  payRecordDao;
     
	
	public void setPayRecordDao(PayRecordDao payRecordDao) {
		this.payRecordDao = payRecordDao;
	}

	@Override
	public PageUtilPayRecord getPage1(int pageno, int pagesize) {
		Map<String,Integer> map=new HashMap<String,Integer>();
        PageUtilPayRecord  page=new PageUtilPayRecord();
        
		int total=payRecordDao.getTotal();
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);

		List list=payRecordDao.getPage(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return payRecordDao.getTotal();
	}

	@Override
	public void insert(PayRecord payRecord) {
		// TODO Auto-generated method stub
		payRecordDao.insert(payRecord);
	}

	@Override
	public void deleteByArray(int[] id) {
		// TODO Auto-generated method stub
		payRecordDao.deleteByArray(id);
	}

	@Override
	public PayRecord findById(int id) {
		// TODO Auto-generated method stub
		return payRecordDao.findById(id);
	}

	@Override
	public List<PayRecord> findByCusAndHetong(String Customer, String hetong) {
		// TODO Auto-generated method stub
		return payRecordDao.findByCusAndHetong(Customer, hetong);
	}

	@Override
	public PageUtilPayRecord findByPaydate(int pageno, int pagesize,String paydate) {
		Map<String,Object> map=new HashMap<String,Object>();
        PageUtilPayRecord  page=new PageUtilPayRecord();
        
		int total=payRecordDao.getTotalByPaydate(paydate);
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);
		map.put("paydate", paydate);

		List list=payRecordDao.findByPaydate(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public int getTotalByPaydate(String paydate) {
		// TODO Auto-generated method stub
		return payRecordDao.getTotalByPaydate(paydate);
	}

}
