package com.pknu.menu.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu.menu.dao.MenuDao;
import com.pknu.menu.service.MenuService;
import com.pknu.menu.vo.MenuVo;
@Service("menuService")
public class MenuServiceImpl implements MenuService{
	@Autowired
	private MenuDao menuDao;
	@Override
	public List<MenuVo> getList(HashMap<String, Object> map) {
		List<MenuVo> menuList = menuDao.getList(map);
		return menuList;
	}

	
}
