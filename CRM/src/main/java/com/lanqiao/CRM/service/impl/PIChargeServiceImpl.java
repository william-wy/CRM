package com.lanqiao.CRM.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.PIChargeDao;
import com.lanqiao.CRM.entity.PICharge;
import com.lanqiao.CRM.service.PICService;
@Service
public class PIChargeServiceImpl implements PICService {
	@Autowired
	PIChargeDao dao;
	@Override
	public int delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(PICharge PIC) throws SQLException {
		// TODO Auto-generated method stub
		if (PIC.getPc_id()!=0) {
			return dao.update(PIC);
		}else{
			return dao.insert(PIC);
		}
	}

	@Override
	public int getTotal() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	@Override
	public PICharge login(String uname, String pwd) throws SQLException {
		// TODO Auto-generated method stub		
		Map<String ,String> map = new HashMap<>();
		map.put("pc_name", uname);
		map.put("pc_psd", pwd);
		return dao.login(map);
	}

	@Override
	public List<PICharge> getPage(int pageno, int pagesize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
