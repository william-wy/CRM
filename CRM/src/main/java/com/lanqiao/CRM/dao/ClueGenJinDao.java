package com.lanqiao.CRM.dao;

import java.util.List;
import com.lanqiao.CRM.entity.ClueGenJin;

public interface ClueGenJinDao {
	public List<ClueGenJin>  findAll();
	public List<ClueGenJin>  findByClue(String clue);
	public void insert(ClueGenJin clue);
	public List<ClueGenJin>  findByWay(String way);
	
	

}
