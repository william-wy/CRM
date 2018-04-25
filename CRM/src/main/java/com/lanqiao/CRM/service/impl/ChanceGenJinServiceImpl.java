package com.lanqiao.CRM.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.ChanceGenJinDao;
import com.lanqiao.CRM.entity.ChanceGenJin;
import com.lanqiao.CRM.service.ChanceGenJinService;

@Service
public class ChanceGenJinServiceImpl implements ChanceGenJinService {

	@Autowired
    private ChanceGenJinDao chanceGenJin;

	public void setChanceGenJin(ChanceGenJinDao chanceGenJin) {
		this.chanceGenJin = chanceGenJin;
	}

	@Override
	public List<ChanceGenJin> findByChance(String chance) {
		// TODO Auto-generated method stub
		return chanceGenJin.findByChance(chance);
	}

	@Override
	public void insert(ChanceGenJin chance) {
		// TODO Auto-generated method stub
		chanceGenJin.insert(chance);
	}

}
