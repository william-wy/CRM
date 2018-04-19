package com.lanqiao.CRM.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.ProductDao;
import com.lanqiao.CRM.entity.Product;
import com.lanqiao.CRM.service.ProductService;
import com.lanqiao.CRM.utils.PageUtil;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
    private ProductDao productDao;
	
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public void insert(Product p) {
		productDao.insert(p);
		
	}

	@Override    
	public void update(Product p) {
		 productDao.update(p);
	}

	@Override
	public Product findByPname(String pname) {
			return productDao.findByPname(pname);
	}

	@Override
	public Product findByPid(int pid) {
		
		return productDao.findByPid(pid);
	}

	@Override
	public int getTotal() {
	
		return productDao.getTotal();
	}

	@Override
	public PageUtil getPage(int pageno, int pagesize) {
		Map<String,Integer> map=new HashMap<String,Integer>();
        PageUtil  page=new PageUtil();
        
		int total=productDao.getTotal();
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);

		List list=productDao.getPage(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public int getTotalByUnit(String unit) {
		// TODO Auto-generated method stub
		return productDao.getTotalByUnit(unit);
	}

	@Override
	public PageUtil findByUnit(int pageno, int pagesize, String unit) {
		Map<Object,Object> map=new HashMap<Object,Object>();
        PageUtil  page=new PageUtil();
        
		int total=productDao.getTotalByUnit(unit);
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);
		map.put("unit", unit);

		List list=productDao.findByUnit(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public int getTotalByGuige(String guige) {
		// TODO Auto-generated method stub
		return productDao.getTotalByGuige(guige);
	}

	@Override
	public PageUtil findByGuige(int pageno, int pagesize, String guige) {
		Map<Object,Object> map=new HashMap<Object,Object>();
        PageUtil  page=new PageUtil();
        
		int total=productDao.getTotalByGuige(guige);
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);
		map.put("guige", guige);

		List list=productDao.findByGuige(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public int getTotalByIntrodu(String introdu) {
		// TODO Auto-generated method stub
		return productDao.getTotalByIntrodu(introdu);
	}

	@Override
	public PageUtil findByIntrodu(int pageno, int pagesize, String introdu) {
		Map<Object,Object> map=new HashMap<Object,Object>();
        PageUtil  page=new PageUtil();
        
		int total=productDao.getTotalByIntrodu(introdu);
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);
		map.put("introdu", introdu);

		List list=productDao.findByIntrodu(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public void deleteByArray(int[] pid) {
		// TODO Auto-generated method stub
		productDao.deleteByArray(pid);
	}
    
}
