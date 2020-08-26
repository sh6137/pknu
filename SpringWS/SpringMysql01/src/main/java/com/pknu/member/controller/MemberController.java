package com.pknu.member.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pknu.member.service.MemberService;
import com.pknu.member.vo.MemberVo;

@Controller
public class MemberController {
		
	@Autowired
	private MemberService memberService;

	@RequestMapping("/")
	public  String   home() {
		return "home";
	}
	
	@RequestMapping("/List")
	public  ModelAndView  list(
			@RequestParam HashMap <String, Object> map) {
		
		List<MemberVo> list = memberService.getList(map);
		System.out.println("list:" + list);
				
		ModelAndView  mv = new ModelAndView();
		mv.addObject("list", list );
		mv.setViewName("list");
		return mv;
	}
	@RequestMapping("/getList")
	public String getList() {
	}
}
