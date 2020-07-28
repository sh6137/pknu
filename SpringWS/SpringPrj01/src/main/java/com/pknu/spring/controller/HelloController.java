package com.pknu.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello() {
		//return "/WEB-INF/views/hello.jsp";
		return "hello";
	}
	
	@RequestMapping("/home")
	public String home() {
		//return "/WEB-INF/views/hello.jsp";
		return "home";
	}
}
