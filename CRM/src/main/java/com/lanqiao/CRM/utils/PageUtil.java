package com.lanqiao.CRM.utils;

import java.util.List;

public class PageUtil<T> {
	private List<T> data ;
	private int totalNum ;  //总数
	private int totalPage ;    //总页数
	private int currentPageno ;   //当前页数

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPageno() {
		return currentPageno;
	}

	public void setCurrentPageno(int currentPageno) {
		this.currentPageno = currentPageno;
	}
	
	
	
}
