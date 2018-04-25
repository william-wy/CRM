package com.lanqiao.CRM.service;

import java.util.List;

import com.lanqiao.CRM.entity.ChanceGenJin;



public interface ChanceGenJinService {
	public List<ChanceGenJin>  findByChance(String chance);
	public void insert(ChanceGenJin chance);
}
