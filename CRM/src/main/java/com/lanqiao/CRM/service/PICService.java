package com.lanqiao.CRM.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.lanqiao.CRM.entity.PICharge;

@Service
public interface PICService extends BaseService<PICharge> {
	public PICharge login(String uname,String pwd) throws SQLException;
}
