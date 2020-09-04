package com.spring.menu.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.menu.dao.MenuDao;
import com.spring.menu.vo.MenuVo;

@Repository("menuDao")
public class MenuDaoImpl implements MenuDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MenuVo> getList(HashMap<String, Object> map) {
				
		// cursor 사용 결과 조회 
		sqlSession.selectList("Menu.MenuList", map);
		
		List<MenuVo> menuList = (List<MenuVo>)map.get("result");
				
		System.out.println(menuList);
		return menuList;
	}

	@Override
	public void setWriteMenu(HashMap<String, Object> map) {
		sqlSession.insert("Menu.MenuInsert", map);
		
	}

	@Override
	public void deleteMenu(HashMap<String, Object> map) {
		sqlSession.delete("Menu.MenuDelete", map);
		
	}
	
	@Override
	public MenuVo getView(HashMap<String, Object> map) {		
		sqlSession.selectList("Menu.MenuView", map) ;
		List<MenuVo> menuList = (List<MenuVo>) map.get("result");
		MenuVo menuVo = menuList.get(0);
		System.out.println( menuVo );
		return menuVo;
	}
	

	@Override
	public void updateMenu(HashMap<String, Object> map) {
		sqlSession.update("Menu.MenuUpdate", map);
		
	}
	
}
