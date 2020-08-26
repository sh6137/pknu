package com.pknu.post.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pknu.post.service.PostService;
import com.pknu.post.vo.PostVo;

//  @RestController : @Controller + @ResponseBody
@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@RequestMapping("/getPost")
	@ResponseBody
	public  HashMap<String, Object> getPostList( 
			@RequestParam HashMap<String, Object> map  ){
		
		List<PostVo> postList = postService.getList(map);
		System.out.println("contr: " + postList);
		map.put("postList",  postList);
		return map;
	}
	@RequestMapping("/json")
	@ResponseBody
	public String json() {
		String str = "{\"name\":\"superman\" ,\r\n" + 
				" \"age\" : 21\r\n" + 
				"}";
		return str;
	}
	
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/static/html/test1.html";
	}
	
	/*
	 * 
	 * 
	 * @RequestMapping("/getJson") public String getJson(
	 * 
	 * @RequestParam HashMap<String, Object> map ){ String json="{\"abc\":\"123\"}";
	 * return json; }
	 */
}
