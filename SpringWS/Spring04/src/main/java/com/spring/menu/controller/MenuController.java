package com.spring.menu.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;

@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/Menus/List")
	public  ModelAndView menuList() {
		
		// stored procedure 에 값을 전달하고 돌려받기 위해 HashMap 사용
		HashMap<String, Object> map  = new HashMap<String, Object>();
		map.put("menu_id", "MENU01");
		
		List<MenuVo> menuList = menuService.getList(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("menus/menulist");
		mv.addObject("menuList", menuList);
		return mv;
	}
	
	@RequestMapping("/Menus/WriteForm")
	public String  writeForm() {
		return "menus/menuwrite";
	}
	
	@RequestMapping("/Menus/Write")
	public String  write(MenuVo vo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("menu_name", vo.getMenu_name());
		menuService.setWriteMenu(map);
		
		return "redirect:/Menus/List";
	}
	
	@RequestMapping("/Menus/Delete")
	public String delete(MenuVo vo) {
		HashMap<String, Object>  map = new HashMap<String, Object>();
		map.put("menu_id", vo.getMenu_id() );
		menuService.deleteMenu( map );
		return "redirect:/Menus/List";
	}
		
	@RequestMapping("/Menus/UpdateForm")
	public ModelAndView updateForm(MenuVo vo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("menu_id", vo.getMenu_id());
		MenuVo menuVo = menuService.getView(map); 
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("menus/menuupdate");
		mv.addObject("menuVo", menuVo);
		return mv;
	}
	
	@RequestMapping("/Menus/Update")
	public String update(MenuVo vo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("menu_id", vo.getMenu_id() );
		map.put("menu_name", vo.getMenu_name() );
		map.put("menu_seq", vo.getMenu_seq() );
		
		menuService.updateMenu( map );
				
		return "redirect:/Menus/List";
	}
	
	
	
	
}
