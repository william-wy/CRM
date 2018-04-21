package com.lanqiao.CRM.dao;

import java.util.List;
import java.util.Map;

import com.lanqiao.CRM.entity.Area;
import com.lanqiao.CRM.entity.Clue;


public interface ClueDao {
	
	public List<Clue>  findAll();
	public Clue findById(int xid);
	public Clue findByXName(String xname);

	public List<Clue> getPage(Map<String,Integer> map);
	public int getTotal();
	public void insert(Clue clue);
	public void deleteByArray(int[] xid);
	public void update(Clue clue);
	public List<Clue> findByXFid(Map<Object,Object> map);
	public int getTotalByXfid(String xfid);

	public Area findById2(int id);
	
	public int getTotalBySome(Clue clue);
	public List<Clue> findBySome(Map<String,Object> map);

}
