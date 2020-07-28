package com.pknu.menu.dao;

import java.util.HashMap;
import java.util.List;

import com.pknu.menu.vo.MenuVo;

public interface MenuDao {
	public List<MenuVo> getList(HashMap<String, Object> map);
}
