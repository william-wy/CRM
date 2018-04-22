package com.lanqiao.CRM.entity;

import java.util.Date;

public class Contract {
	int hid;
	String hname;
	String hclient_name;
	String hchance_name;
	String hproduct;
	int htol_amt;
	Date hcontract_date;
	Date hstart_date;
	Date hend_date;
	String hstate;
	int hnumber;
	String hstyle;
	String hpay_method;
	String hclient_singer;
	String hcompany_singer;
	String haccessory;
	Date hnext_date;
	String hpayment_plan;
	String remark;
	String hfname;
	int deptno;
	
	private String taskID;
	
	public String getTaskID() {
		return taskID;
	}
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getHclient_name() {
		return hclient_name;
	}
	public void setHclient_name(String hclient_name) {
		this.hclient_name = hclient_name;
	}
	public String getHchance_name() {
		return hchance_name;
	}
	public void setHchance_name(String hchance_name) {
		this.hchance_name = hchance_name;
	}
	public String getHproduct() {
		return hproduct;
	}
	public void setHproduct(String hproduct) {
		this.hproduct = hproduct;
	}
	public int getHtol_amt() {
		return htol_amt;
	}
	public void setHtol_amt(int htol_amt) {
		this.htol_amt = htol_amt;
	}
	public Date getHcontract_date() {
		return hcontract_date;
	}
	public void setHcontract_date(Date hcontract_date) {
		this.hcontract_date = hcontract_date;
	}
	public Date getHstart_date() {
		return hstart_date;
	}
	public void setHstart_date(Date hstart_date) {
		this.hstart_date = hstart_date;
	}
	public Date getHend_date() {
		return hend_date;
	}
	public void setHend_date(Date hend_date) {
		this.hend_date = hend_date;
	}
	public String getHstate() {
		return hstate;
	}
	public void setHstate(String hstate) {
		this.hstate = hstate;
	}
	public int getHnumber() {
		return hnumber;
	}
	public void setHnumber(int hnumber) {
		this.hnumber = hnumber;
	}
	public String getHstyle() {
		return hstyle;
	}
	public void setHstyle(String hstyle) {
		this.hstyle = hstyle;
	}
	public String getHpay_method() {
		return hpay_method;
	}
	public void setHpay_method(String hpay_method) {
		this.hpay_method = hpay_method;
	}
	public String getHclient_singer() {
		return hclient_singer;
	}
	public void setHclient_singer(String hclient_singer) {
		this.hclient_singer = hclient_singer;
	}
	public String getHcompany_singer() {
		return hcompany_singer;
	}
	public void setHcompany_singer(String hcompany_singer) {
		this.hcompany_singer = hcompany_singer;
	}
	public String getHaccessory() {
		return haccessory;
	}
	public void setHaccessory(String haccessory) {
		this.haccessory = haccessory;
	}
	public Date getHnext_date() {
		return hnext_date;
	}
	public void setHnext_date(Date hnext_date) {
		this.hnext_date = hnext_date;
	}
	public String getHpayment_plan() {
		return hpayment_plan;
	}
	public void setHpayment_plan(String hpayment_plan) {
		this.hpayment_plan = hpayment_plan;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getHfname() {
		return hfname;
	}
	public void setHfname(String hfname) {
		this.hfname = hfname;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
}
