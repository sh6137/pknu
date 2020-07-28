package com.pknu.menu.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pknu.menu.dao.MenuDao;
import com.pknu.menu.vo.MenuVo;
@Repository("menuDao")
public class MenuDaoImpl implements MenuDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MenuVo> getList(HashMap<String, Object> map) {
		List<MenuVo> menuList = sqlSession.selectList("Menu.MenuList");
		return menuList;
	}

}
