package com.lanqiao.CRM.service;

import java.util.List;
import com.lanqiao.CRM.entity.ClueGenJin;


public interface ClueGenJinService {
	public List<ClueGenJin>  findAll();
	public List<ClueGenJin>  findByClue(String clue);
	public void insert(ClueGenJin clue);
	public List<ClueGenJin>  findByWay(String way);
}
