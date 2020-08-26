package com.pknu.naverapi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pknu.naverapi.service.NewsService;

@Controller
public class JQMController {

	@Autowired
	private NewsService newsService;
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/static/html/index.html";
	}
	
	@RequestMapping("/{location}")
	public String html(
			@PathVariable ("location") String loc) {
		return "redirect:/static/html/" + loc + ".html";
	}
		
	
}
