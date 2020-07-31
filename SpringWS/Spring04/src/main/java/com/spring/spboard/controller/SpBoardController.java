package com.spring.spboard.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.spboard.service.SpBoardService;
import com.spring.spboard.vo.SpBoardVo;

@Controller
public class SpBoardController {
	
	@Autowired
	private SpBoardService spBoardService;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/SpBoard/List")
	public ModelAndView list() {
		
		List<SpBoardVo> spBoardList = spBoardService.getList();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("spboard/list");
		mv.addObject("spBoardList", spBoardList );
		return  mv;
	}
	
	@RequestMapping("/SpBoard/WriteForm")
	public String writeForm() {
		return "spboard/write";
	}
	
	@RequestMapping("/SpBoard/Write")
	public String write(SpBoardVo vo) {
		// request정보를 vo
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", vo.getTitle() );
		map.put("name",  vo.getName() );
		spBoardService.addBoard(map);
		
		return "redirect:/SpBoard/List";
	}
	
	@RequestMapping("/SpBoard/Delete")
	public ModelAndView delete(
		  @RequestParam	HashMap<String, Object> map) {
		System.out.println("map:" + map);
		System.out.println("idx:" + map.get("idx"));
		spBoardService.delete(map);
		
		ModelAndView mv =  new ModelAndView();
		mv.setViewName("redirect:/SpBoard/List");
		return mv;
	}
	
	@RequestMapping("/SpBoard/UpdateForm")
	public ModelAndView updateForm(
		@RequestParam HashMap<String, Object> map) {
		
		List<SpBoardVo> spBoardVo = spBoardService.getView(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("spboard/update");
		mv.addObject("spBoardVo", spBoardVo.get(0));
		
		return mv;
	}
	
	@RequestMapping("/SpBoard/Update")
	public ModelAndView update(
			@RequestParam HashMap<String, Object> map) {
		
		spBoardService.updateBoard(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/SpBoard/List");
				
		return mv;
	}
	
}
