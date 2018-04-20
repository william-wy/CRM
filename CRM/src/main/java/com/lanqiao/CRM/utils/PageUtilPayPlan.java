package com.lanqiao.CRM.utils;

import java.util.List;

import com.lanqiao.CRM.entity.PayPlan;



public class PageUtilPayPlan {
	private List<PayPlan> data ;
	private int totalNum ;  //总数
	private int totalPage ;    //总页数
	private int currentPageno ;   //当前页数

	public List<PayPlan> getData() {
		return data;
	}

	public void setData(List<PayPlan> data) {
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
