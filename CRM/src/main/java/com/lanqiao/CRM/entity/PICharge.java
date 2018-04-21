package com.lanqiao.CRM.entity;

public class PICharge {
	
	private int pc_id;
	private String pc_name;
	private String pc_dept;
	private int pc_role_id;
	private String pc_psd;
	
	
	public int getPc_role_id() {
		return pc_role_id;
	}
	public void setPc_role_id(int pc_role_id) {
		this.pc_role_id = pc_role_id;
	}
	public int getPc_id() {
		return pc_id;
	}
	public void setPc_id(int pc_id) {
		this.pc_id = pc_id;
	}
	public String getPc_name() {
		return pc_name;
	}
	public void setPc_name(String pc_name) {
		this.pc_name = pc_name;
	}
	public String getPc_dept() {
		return pc_dept;
	}
	public void setPc_dept(String pc_dept) {
		this.pc_dept = pc_dept;
	}
	public String getPc_psd() {
		return pc_psd;
	}
	public void setPc_psd(String pc_psd) {
		this.pc_psd = pc_psd;
	}
	
}
