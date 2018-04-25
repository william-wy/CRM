package com.lanqiao.CRM.dao;

import java.util.List;

import com.lanqiao.CRM.entity.ChanceGenJin;

public interface ChanceGenJinDao {
	public List<ChanceGenJin>  findByChance(String chance);
	public void insert(ChanceGenJin chance);
}
