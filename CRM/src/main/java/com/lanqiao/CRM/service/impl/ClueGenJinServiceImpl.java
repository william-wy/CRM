package com.lanqiao.CRM.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.ClueGenJinDao;
import com.lanqiao.CRM.entity.ClueGenJin;
import com.lanqiao.CRM.service.ClueGenJinService;


@Service
public class ClueGenJinServiceImpl implements ClueGenJinService{
	
	@Autowired
    private ClueGenJinDao clueGenJin;

	public void setClueGenJin(ClueGenJinDao clueGenJin) {
		this.clueGenJin = clueGenJin;
	}

	@Override
	public List<ClueGenJin> findByClue(String clue) {
		// TODO Auto-generated method stub
		return clueGenJin.findByClue(clue);
	}
	
	@Override
	public void insert(ClueGenJin clue) {
		// TODO Auto-generated method stub
		clueGenJin.insert(clue);
	}

	@Override
	public List<ClueGenJin> findByWay(String way) {
		// TODO Auto-generated method stub
		return clueGenJin.findByWay(way);
	}

	@Override
	public List<ClueGenJin> findAll() {
		// TODO Auto-generated method stub
		return clueGenJin.findAll();
	}
	
	
}
