package com.spring.menu.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.menu.vo.MenuVo;

public interface MenuDao {

	List<MenuVo> getList(HashMap<String, Object> map);

	void setWriteMenu(HashMap<String, Object> map);

}
