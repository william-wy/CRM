package com.lanqiao.CRM.utils;

import java.util.List;

import com.lanqiao.CRM.entity.Menu;

/**
 * 菜单工具类
 *
 */

public class MenuTree {
	
	private int id ;
	private String text ;
	private List<Menu> children ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<Menu> getChildren() {
		return children;
	}
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	
	

}
