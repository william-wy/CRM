package com.lanqiao.CRM.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.ContractDao;
import com.lanqiao.CRM.entity.Contract;
import com.lanqiao.CRM.service.ContractService;
import com.lanqiao.CRM.utils.PageUtil;
@Service
public class ContractServiceImpl implements ContractService{
	@Autowired
	ContractDao dao;
	@Override
	public int delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public int save(Contract contract) throws SQLException {
		// TODO Auto-generated method stub
		if (contract.getHid()==0) {
			return dao.insert(contract);
		}else{
			return dao.update(contract);
		}
		
	}

	@Override
	public int getTotal() throws SQLException {
		// TODO Auto-generated method stub
		return dao.getTotal();
	}

	@Override
	public List<Contract> getPage(int pageno, int pagesize) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
		map.put("start", pageno);
		map.put("end", pagesize);
		
		return dao.getPage(map);
	}

	@Override
	public PageUtil<Contract> getPage1(int pageno, int pagesize) {
		Map<String,Integer> map=new HashMap<>();
        PageUtil<Contract>  page=new PageUtil<>();
        List<Contract> list = null;
        int pageTotal=0;
        int total = 0;
		try {
		total=dao.getTotal();
		pageTotal=(total%pagesize==0)?total/pagesize:total/pagesize+1;
		if(pageno>pageTotal) {
			pageno=pageTotal;
		}else if(pageno<=0) {
			pageno=1;
		}
		
		map.put("start",(pageno-1)*pagesize);
		map.put("end", pagesize);

		
			list = dao.getPage(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		page.setData(list);
		page.setTotalNum(total);
		page.setTotalPage(pageTotal);
		page.setCurrentPageno(pageno);

		return page;
	}

	//工作流
	@Override
	public PageUtil<Contract> findByXFid(int pageno, int pagesize, String xfid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Contract getContract(String hstatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contract getBusiness(int pc_id, String hstatus) {
		
		
		return dao.getBusiness(pc_id, hstatus);
		
	}
	@Override
	public void updateStatusById(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		dao.updateStatusById(map);
	}

	@Override
	public Contract get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public void updateStatus(String statu,int hid){
		// TODO Auto-generated method stub
		Map<String,Object> map= new HashMap<>();
		map.put("hstate", statu);
		map.put("hid", hid);
		
		dao.updateStatus(map);
	}
	

}
