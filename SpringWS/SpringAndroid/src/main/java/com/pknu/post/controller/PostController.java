package com.pknu.post.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//  @RestController : @Controller + @ResponseBody
@RestController
public class PostController {

	@RequestMapping("/getPost")
	public  HashMap<String, Object> getPostList( 
			@RequestParam HashMap<String, Object> map  ){
		
		
		
		return map;
	}
	
}
