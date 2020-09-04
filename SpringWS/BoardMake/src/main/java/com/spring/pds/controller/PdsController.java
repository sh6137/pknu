package com.spring.pds.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;
import com.spring.pds.service.PdsService;
import com.spring.pds.vo.PdsVo;



@Controller
public class PdsController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private PdsService pdsService;
	
	@RequestMapping("/PDS/List")
	public ModelAndView pdsList(PdsVo vo) {
		// Board + Files 조회 : menu_id 에 해당되는 
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("menu_id", vo.getMenu_id());
		
		List<PdsVo> pdsList = pdsService.getPdsList(map); //조회시 사용할 map 안에 menu_id 를 넣어준다.
		
		// Menus  조회
		List<MenuVo> menuList = menuService.getList(map); //menu_id  전달됨
				
		// list.jsp 위한 준비
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pds/list");
		mv.addObject("menuList", menuList); //전체 메류초회
		mv.addObject("pdsList", pdsList); //조회된글
		mv.addObject("menu_id",  vo.getMenu_id()); //조회된글
		
		return mv;		
	}
}
