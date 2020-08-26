package com.pknu.jqm02.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class JQMController {

	@Autowired
	//private NewsService newsService;
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/static/html/index.html";
	}
	
	@RequestMapping("/test1")
	public String test1() {
		return "redirect:/static/html/test1.html";
	}
		
	@RequestMapping("/test2")
	public String test2() {
		return "redirect:/static/html/test2.html";
	}
	
	@RequestMapping("/test3")
	public String test3() {
		return "redirect:/static/html/test3.html";
	}
	
	@RequestMapping("/mainpage")
	public String mainpage() {
		return "redirect:/static/html/mainpage.html";
	}
	
	@RequestMapping("/postlist")
	public String postlist() {
		return "redirect:/static/html/postlist.html";
	}
	
	
}
