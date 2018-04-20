package com.lanqiao.CRM.entity;

public class PayRecord {
int id;
String paydate;
Double paymoney;
String customer;
String contract;
String payperiod;
String paymethod;
String paytype;
String payee;
String remark;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPaydate() {
	return paydate;
}
public void setPaydate(String paydate) {
	this.paydate = paydate;
}
public Double getPaymoney() {
	return paymoney;
}
public void setPaymoney(Double paymoney) {
	this.paymoney = paymoney;
}
public String getCustomer() {
	return customer;
}
public void setCustomer(String customer) {
	this.customer = customer;
}
public String getContract() {
	return contract;
}
public void setContract(String contract) {
	this.contract = contract;
}
public String getPayperiod() {
	return payperiod;
}
public void setPayperiod(String payperiod) {
	this.payperiod = payperiod;
}
public String getPaymethod() {
	return paymethod;
}
public void setPaymethod(String paymethod) {
	this.paymethod = paymethod;
}
public String getPaytype() {
	return paytype;
}
public void setPaytype(String paytype) {
	this.paytype = paytype;
}
public String getPayee() {
	return payee;
}
public void setPayee(String payee) {
	this.payee = payee;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
}
