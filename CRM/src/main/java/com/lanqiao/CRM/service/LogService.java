package com.lanqiao.CRM.service;



import java.util.List;
import java.util.Map;

import com.lanqiao.CRM.entity.Log;
import com.lanqiao.CRM.utils.PageUtil;

public interface LogService {
	public List<Log> findAll(String s);
	public int getTotal(String s);
}
