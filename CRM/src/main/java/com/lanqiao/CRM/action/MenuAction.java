package com.lanqiao.CRM.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.CRM.entity.PICharge;
import com.lanqiao.CRM.service.MenuService;
import com.lanqiao.CRM.utils.MenuTree;

@Controller
@RequestMapping("/menu")
public class MenuAction {

	@Autowired
	private MenuService menuService ;
	
	@RequestMapping("/getMenuTreeByRole.action")
	public @ResponseBody List<MenuTree> getMenuTreeByRole(String user){
		
		int user1=Integer.parseInt(user);
		int user2=menuService.getRole(user1);
		List<MenuTree> tree = menuService.getMenuTreeByRole(user2) ;
		System.out.println(tree.get(0).getChildren());
		return tree ;
	}
	
	@RequestMapping("/getMenuTree.action")
	public @ResponseBody List<MenuTree> getMenuTree(int roleid) throws SQLException{
		
		List<MenuTree> tree = menuService.getMenuTree(roleid) ;
		return tree ;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
}
