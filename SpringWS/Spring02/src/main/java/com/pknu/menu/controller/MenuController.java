package com.pknu.menu.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pknu.menu.service.MenuService;
import com.pknu.menu.vo.MenuVo;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/Menus/List")
	public ModelAndView menuList() {
		//stored procedure 에 값을 전달하고 돌려받기 위해
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("menu_id","MENU01");
		
		List<MenuVo> menuList = menuService.getList(map);
	
		ModelAndView mv= new ModelAndView();
		mv.setViewName("menus/menulist");
		mv.addObject("menuList",menuList);
		return mv;
	}
	@RequestMapping("/Menus/WriteForm")
	public String writeForm() {
		return "menus/menuwrite";
	}
	@RequestMapping("/Menus/Write")
	public String write(MenuVo vo) {
		return "redirect:/MenusList";
	}
}
