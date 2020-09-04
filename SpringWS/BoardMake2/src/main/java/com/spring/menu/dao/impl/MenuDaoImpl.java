package com.spring.menu.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.menu.dao.MenuDao;
import com.spring.menu.vo.MenuVo;
@Repository("menuDao")
public class MenuDaoImpl implements MenuDao{

	@Autowired
	private SqlSession sqlSession;
	@Override
	public List<MenuVo> getList(HashMap<String, Object> map) {
		sqlSession.selectList("Menu.MenuList",map);
		List<MenuVo> menuList = (List<MenuVo>)map.get("result");
		
		System.out.println(menuList);
		return menuList;
	}
	
}
