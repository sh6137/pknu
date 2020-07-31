package com.spring.menu.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.menu.vo.MenuVo;

public interface MenuDao {
	
	public List<MenuVo> getList(HashMap<String, Object> map);

	public void setWriteMenu(HashMap<String, Object> map);

	public void deleteMenu(HashMap<String, Object> map);

	public MenuVo getView(HashMap<String, Object> map);

	public void updateMenu(HashMap<String, Object> map);
	
}
