package com.lanqiao.CRM.entity;

public class PayPlan {
int planid;
String customer;
String contract;
String contractcost;
String signdate;
public int getPlanid() {
	return planid;
}
public void setPlanid(int planid) {
	this.planid = planid;
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
public String getContractcost() {
	return contractcost;
}
public void setContractcost(String contractcost) {
	this.contractcost = contractcost;
}
public String getSigndate() {
	return signdate;
}
public void setSigndate(String signdate) {
	this.signdate = signdate;
}
}
