package com.pknu.spring.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pknu.spring.vo.BoardVo;

@Controller
public class TempController {
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	@RequestMapping("/temp1")
	public String temp(HttpServletRequest request, HttpServletResponse reponse) {
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		
		HttpSession session = request.getSession();
		
		System.out.println("temp1");
		System.out.println("a="+a);
		System.out.println("b="+b);
		return "none";
	}
	
	@RequestMapping("/temp2")
	public String temp(@RequestParam Map<String, String> map) {
		String a = map.get("a");
		String b = map.get("b");
		
		System.out.println("temp2");
		System.out.println("a="+a);
		System.out.println("b="+b);
		return "none1";
	}
	@RequestMapping("/temp3")
	public String temp(
			@RequestParam("a") String a,
			@RequestParam("b") int b) {
		
		System.out.println("temp3");
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		return "none";
	}
	
	@RequestMapping("/temp4")
	public String temp(BoardVo vo) {
		
		System.out.println("temp4");
		System.out.println("a="+vo.getA());
		System.out.println("b="+vo.getB());
		
		return "none";
	}
	
	//*****************************************************
	
	@RequestMapping("/temp5")
	public String temp(
			@RequestParam("a") String a,
			@RequestParam("b") int b,
			Model model) {
		//Model : 다른 페이지로 값을 전달하기 위해 담는 객체
		
		System.out.println("temp5");
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		//Model 의 내용 확인 : model 안에는 자료가 map 구조로 저장
		model.addAttribute("a",a);
		model.addAttribute("b",b);
		System.out.println("Model 안의 내용");
		Map<String, Object> map = model.asMap();
		System.out.println("---------------");
		for(String key : map.keySet()) {
			System.out.println(key +":"+ map.get(key).toString());
		}
		System.out.println("---------------");
		
		return "none";
	}
	
	@RequestMapping("/temp6")
	public String temp(
			BoardVo vo,
			Model model) {
		//Model : 다른 페이지로 값을 전달하기 위해 담는 객체
		
		System.out.println("temp6");
		System.out.println("a="+vo.getA());
		System.out.println("b="+vo.getB());
		
		//Model 의 내용 확인 : model 안에는 자료가 map 구조로 저장
		model.addAttribute("a",vo.getA());
		model.addAttribute("b",vo.getB());
		System.out.println("Model 안의 내용");
		Map<String, Object> map = model.asMap();
		System.out.println("---------------");
		for(String key : map.keySet()) {
			System.out.println(key +":"+ map.get(key).toString());
		}
		System.out.println("---------------");
		
		return "none";
	}
	
	@RequestMapping("/temp7")
	public String tempModel(
			@ModelAttribute("attrName") BoardVo vo,
			Model model) {
		//Model : 다른 페이지로 값을 전달하기 위해 담는 객체
		
		System.out.println("temp7");
		System.out.println("a="+vo.getA());
		System.out.println("b="+vo.getB());
		
		//Model 의 내용 확인 : model 안에는 자료가 map 구조로 저장
		
		System.out.println("Model 안의 내용");
		Map<String, Object> map = model.asMap();
		System.out.println("---------------");
		for(String key : map.keySet()) {
			System.out.println(key +":"+ map.get(key).toString());
		}
		System.out.println("---------------");
		
		return "noneModel";
	}
	
	//PathVariable
	//어떤 규칙으로 파라미터를 가져올까에 대한 규칙
	@RequestMapping("/temp8/{a}/{b}")
	public String tempPath(
			@PathVariable("a") String a,
			@PathVariable("b") int b
			) {
		System.out.println("temp8");
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		
		return "none";
	}
	
	@RequestMapping("/temp9/{a}/{b}")
	public String tempPath(
			BoardVo vo) {
		System.out.println("temp9");
		System.out.println("a="+vo.getA());
		System.out.println("b="+vo.getB());
		
		
		return "none";
	}
	
	@RequestMapping("/temp10/{a}/{b}")
	public String tempPath(
			@ModelAttribute("attrName") BoardVo vo,
			Model model) {
		System.out.println("temp10");
		System.out.println("a="+vo.getA());
		System.out.println("b="+vo.getB());
		
		
		return "noneModel";
	}
	
}
