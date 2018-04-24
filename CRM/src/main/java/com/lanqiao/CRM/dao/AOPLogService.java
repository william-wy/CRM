package com.lanqiao.CRM.dao;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.lanqiao.CRM.entity.Clue;
/**
 * 日志类
 * @author wangyi
 *
 */
@Aspect
@Component
public class AOPLogService {
	
	public AOPLogService(){
		
		System.out.println("========日志信息========");
		
	}
	
	@Before("execution(* com.lanqiao.CRM.dao.ClueDao.insert(..))")
    public void beforeinsert() {
		
		System.out.println("====正在插入数据====");
		
	}

	@After("execution(* com.lanqiao.CRM.dao.ClueDao.insert(..))")
	public void afterinsert() {
		
		System.out.println("====数据插入完毕====");
		
	}

}
