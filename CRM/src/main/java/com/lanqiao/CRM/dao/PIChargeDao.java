package com.lanqiao.CRM.dao;

import java.sql.SQLException;

import java.util.Map;

import com.lanqiao.CRM.entity.PICharge;
public interface PIChargeDao extends BaseDao<PICharge> {
	public PICharge login(Map<String,String> map) throws SQLException;
}
