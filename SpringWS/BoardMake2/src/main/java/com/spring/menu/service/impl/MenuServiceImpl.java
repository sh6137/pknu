package com.spring.menu.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.menu.dao.MenuDao;
import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;
@Service("menuService")
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuDao menuDao;
	@Override
	public List<MenuVo> getList(HashMap<String, Object> map) {
			List<MenuVo> menuList = menuDao.getList(map);
		return menuList;
	}
	@Override
	public void setWriteMenu(HashMap<String, Object> map) {
			
		menuDao.setWriteMenu(map);
	}

}
