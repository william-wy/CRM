package com.lanqiao.CRM.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lanqiao.CRM.dao.LogDao;
import com.lanqiao.CRM.entity.Log;

/**
 * 日志类
 * @author wangyi
 *
 */
@Aspect
@Component
public class AOPLogService {
	
	@Autowired
	private LogDao logDao1;
	
	public AOPLogService(){
		
		System.out.println("========日志信息========");
		
	}

	@After(value="execution(* com.lanqiao.CRM.dao.ClueDao.insert(..))")
	public void afterinsert() {
		
		Log log = new Log();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String log_createtime=df.format(new Date());
		
		log.setLog_createtime(log_createtime);
		log.setLog_operation("增加一条线索");
		log.setLog_type("clue");
		
		logDao1.insert(log);
		
		System.out.println("====数据插入完毕====");
		
	}
	
	@After(value="execution(* com.lanqiao.CRM.dao.ClueDao.deleteByArray(..))")
	public void afterdeleteByArray() {
		
		Log log = new Log();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String log_createtime=df.format(new Date());
		
		log.setLog_createtime(log_createtime);
		log.setLog_operation("删除一条线索");
		log.setLog_type("clue");
		
		logDao1.insert(log);
		
		System.out.println("====数据插入完毕====");
		
	}
	
	@After(value="execution(* com.lanqiao.CRM.dao.ClueDao.update(..))")
	public void afterupdate() {
		
		Log log = new Log();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String log_createtime=df.format(new Date());
		
		log.setLog_createtime(log_createtime);
		log.setLog_operation("修改一条线索");
		log.setLog_type("clue");
		
		logDao1.insert(log);
		
		System.out.println("====数据插入完毕====");
		
	}
	
	@After(value="execution(* com.lanqiao.CRM.action.ClueAction.zhuanyi(..))")
	public void aftertokh() {
		
		Log log = new Log();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String log_createtime=df.format(new Date());
		
		log.setLog_createtime(log_createtime);
		log.setLog_operation("一条线索转换为客户");
		log.setLog_type("clue");
		
		logDao1.insert(log);
		
		System.out.println("====数据插入完毕====");
		
	}

}
