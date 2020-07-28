package com.pknu.menu.service;

import java.util.HashMap;
import java.util.List;

import com.pknu.menu.vo.MenuVo;

public interface MenuService {

	List<MenuVo> getList(HashMap<String, Object> map);



	
}
