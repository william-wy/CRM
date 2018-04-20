package com.lanqiao.CRM.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.BillRecordDao;
import com.lanqiao.CRM.entity.Billrecord;
import com.lanqiao.CRM.service.BillRecordService;
import com.lanqiao.CRM.utils.PageUtilBillRecord;


@Service
public class BillRecordServiceImpl implements BillRecordService{
   @Autowired
	private BillRecordDao billRecordDao;
	
	public void setBillRecordDao(BillRecordDao billRecordDao) {
	this.billRecordDao = billRecordDao;
}

	@Override
	public PageUtilBillRecord getPage1(int pageno, int pagesize) {
		Map<String,Integer> map=new HashMap<String,Integer>();
        PageUtilBillRecord  page=new PageUtilBillRecord();
        
		int total=billRecordDao.getTotal();
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);

		List list=billRecordDao.getPage(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return billRecordDao.getTotal();
	}

	@Override
	public void insert(Billrecord billRecord) {
		// TODO Auto-generated method stub
		billRecordDao.insert(billRecord);
	}

	@Override
	public void deleteByArray(int[] id) {
		// TODO Auto-generated method stub
		billRecordDao.deleteByArray(id);
	}

}
