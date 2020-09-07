package com.spring.menu.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;

@Controller
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	
	@RequestMapping("/Menus/List")
	public ModelAndView menuList(@RequestParam HashMap<String, Object> map) {
		
		map.put("menu_id", "MENU01");
		
		List<MenuVo> menuList = menuService.getList(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("menus/menulist");
		mv.addObject("menuList", menuList);
		
		return mv;
	}
	
	@RequestMapping("/Menus/WriteForm")
	public String writeForm() {
		return "menus/menuwrite";
	}
}
