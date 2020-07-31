package com.spring.pds.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;
import com.spring.pds.service.PdsService;

@Controller
public class PdsController {
	
	@Autowired
	private MenuService menuService;
	@Autowired
	private PdsService pdsService;
	
	@RequestMapping("/PDS/List")
	public ModelAndView pdsList(
		@RequestParam HashMap<String, Object> map) {
		
		List<MenuVo> menuList = menuService.getList(map);
		ModelAndView mv = new ModelAndView();
		mv.addObject("menuList", menuList);
		mv.addObject("menu_id", map.get("menu_id"));
		mv.setViewName("pds/list");
		return mv;
	}
	
	@RequestMapping("/PDS/WriteForm")
	public ModelAndView writeForm(
		@RequestParam HashMap<String, Object> map){
		
		//menu_id:MENU01
		// /PDS/WriteForm?menu_id=${menu_id}&bnum=0&lvl=0&step=0&nref=0&nowpage=${nowpage}&pagegrpnum=${pagegrpnum}
		// user_id:'sky';
		System.out.println("WriteForm dfsdfs  :" + map);
		
		List<MenuVo> menuList = menuService.getList(map);
		//로그인 아이디
		map.put("uesr_id","sky");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("menuList", menuList);
		mv.addObject("map", map); //request 정보들 + user_id
		mv.setViewName("pds/write");
		return mv;
	}
	@RequestMapping("/PDS/Write") //글쓰기
	public ModelAndView write(
			@RequestParam HashMap<String, Object> map, HttpServletRequest request) { //정보 받기
		ModelAndView mv = new ModelAndView();
		
		List<MenuVo> menuList = menuService.getList(map);
		mv.addObject("menuList", menuList);
		
		mv.addObject("menu_id", map.get("menu_id"));
		
		//페이징 관련 처리
		mv.addObject("nowpage", map.get("nowpage"));
		mv.addObject("pagegrpnum", map.get("pagegrpnum"));
		pdsService.setWrite(map, request);
		mv.setViewName("redirect:/PDS/List");
		return mv;
	}
	
	
}
