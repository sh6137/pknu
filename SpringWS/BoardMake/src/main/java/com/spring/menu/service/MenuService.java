package com.spring.menu.service;

import java.util.HashMap;
import java.util.List;

import com.spring.menu.vo.MenuVo;

public interface MenuService {

	List<MenuVo> getList(HashMap<String, Object> map);

	void setWriteMenu(HashMap<String, Object> map);

	void deleteMenu(HashMap<String, Object> map);

	MenuVo getView(HashMap<String, Object> map);

	void updateMenu(HashMap<String, Object> map);
	
	
	
}
