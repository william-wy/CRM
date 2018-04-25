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
	public int getTotalByUnitAndLeibie(String unit,String sort) {
		// TODO Auto-generated method stub
		return productDao.getTotalByUnitAndLeibie(unit, sort);
	}

	@Override
	public PageUtil findByUnitAndLeibie(int pageno, int pagesize, String unit,String sort) {
		Map<Object,Object> map=new HashMap<Object,Object>();
        PageUtil  page=new PageUtil();
        
		int total=productDao.getTotalByUnitAndLeibie(unit, sort);
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);
		map.put("unit", unit);
		map.put("sort", sort);

		List list=productDao.findByUnitAndLeibie(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	

	@Override
	public int getTotalByNameAndLeibie(String pname,String sort) {
		// TODO Auto-generated method stub
		return productDao.getTotalByNameAndLeibie(pname, sort);
	}

	@Override
	public PageUtil findByNameAndLeibie(int pageno, int pagesize, String pname,String sort) {
		Map<Object,Object> map=new HashMap<Object,Object>();
        PageUtil  page=new PageUtil();
        
		int total=productDao.getTotalByNameAndLeibie(pname,sort);
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);
		map.put("pname", pname);
		map.put("sort", sort);
		

		List list=productDao.findByNameAndLeibie(map);
	    
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

	@Override
	public PageUtil findByLeibie(int pageno, int pagesize, String sort) {
		Map<Object,Object> map=new HashMap<Object,Object>();
        PageUtil  page=new PageUtil();
        
		int total=productDao.getTotalByLeibie(sort);
		int pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);
		map.put("sort", sort);

		List list=productDao.findByLeibie(map);
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	@Override
	public int getTotalByLeibie(String leibie) {
		
		return productDao.getTotalByLeibie(leibie);
	}
    
}
