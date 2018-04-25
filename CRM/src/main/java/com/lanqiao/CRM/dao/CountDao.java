package com.lanqiao.CRM.dao;

import java.util.List;


import com.lanqiao.CRM.entity.ChanPin;
import com.lanqiao.CRM.entity.GenJinCiShu;
import com.lanqiao.CRM.entity.HeTong;
import com.lanqiao.CRM.entity.HuiKuanJiHua;
public interface CountDao {
	List<HeTong> countcontract();
	List<HuiKuanJiHua> countpayplan();
	List<ChanPin> countproduct();
	List<GenJinCiShu> counttime();
}
