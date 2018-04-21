package com.lanqiao.CRM.service;

import java.util.List;
import com.lanqiao.CRM.entity.Area;
import com.lanqiao.CRM.entity.Clue;
import com.lanqiao.CRM.utils.PageUtil;


public interface ClueService {
	
	public List<Clue> findAll();
	public Clue findById(int id);
	public Clue findByXName(String xname);

	public int getTotal();

	public PageUtil getPage1(int pageno,int pagesize);
	public void insert (Clue clue);

	public void deleteByArray(int[] xid);
	public void update(Clue clue);
	public PageUtil findByXFid(int pageno, int pagesize,String xfid);
	public int getTotalByXfid(String xfid);


	public Area findById2(int id);
	
	public PageUtil findBySome(int pageno, int pagesize,Clue clue);

}
