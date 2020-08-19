package com.pknu.naverapi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pknu.naverapi.service.NewsService;

@Controller
public class NaverNewsController {

	@Autowired
	private NewsService newsService;
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/static/html/naverNews.html";
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public void newList(String keyword,
			HttpServletResponse response) {
		String json = newsService.searchNews(keyword, 10, 1);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
}
