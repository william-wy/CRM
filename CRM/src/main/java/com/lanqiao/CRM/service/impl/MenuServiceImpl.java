package com.lanqiao.CRM.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.CRM.dao.MenuDao;
import com.lanqiao.CRM.entity.Menu;
import com.lanqiao.CRM.entity.Role;
import com.lanqiao.CRM.service.MenuService;
import com.lanqiao.CRM.utils.MenuTree;
import com.lanqiao.CRM.utils.PageUtil;

@Service
public class MenuServiceImpl implements MenuService{

	
	@Autowired
	private MenuDao menuDao ;

	@Override
	public List<Menu> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotal() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageUtil<Menu> getPage2(int pageno, int pagesize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MenuTree> getMenuTreeByRole(int roleid) {
		
        List<MenuTree> mt = new ArrayList<MenuTree>() ;
		
		List<Menu> list = menuDao.getMenuByRole(roleid) ;
		for(Menu menu : list){
			if(menu.getPid() == 0){
				MenuTree m = new MenuTree();
				m.setId(menu.getId());
				m.setText(menu.getText());
				List<Menu> child = new ArrayList<Menu>();
				//得到当前一级菜单下面的子菜单
				for(Menu mm : list){
					if(mm.getPid() == m.getId()){
						child.add(mm) ;
					}
				}
				m.setChildren(child);
				
				mt.add(m) ;
			}
		}
		
		return mt;
	}

	@Override
	public List<MenuTree> getMenuTree(int roleid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveFengpei(int roleid, int userid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getRole(int pc_id) {
		// TODO Auto-generated method stub
		return menuDao.getRole(pc_id);
	}
	
	

}
