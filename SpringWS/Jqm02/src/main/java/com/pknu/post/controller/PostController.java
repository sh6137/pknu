package com.pknu.post.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pknu.post.vo.PostVo;

@RestController
public class PostController {

	@RequestMapping("/getAddr")	
	public String getAddr(String dong) {
		PostVo vo1 = new PostVo("010-122", "부산", 
				"남구", "용당동", "부경대 용당 캠퍼스", 12345 );
		PostVo vo2 = new PostVo("010-120", "부산", 
				"남구", "대연동", "부경대 대연 캠퍼스", 12340 );
		String json = "[" +
				vo1.toJSON() + "," +
				vo2.toJSON() +
				"]"; 
		return json;
	}
	
	@RequestMapping("/getAddrList")	
	public HashMap<String, Object> getAddrList(
			@RequestParam HashMap<String, Object>map) {
		PostVo vo1 = new PostVo("010-122", "부산", 
				"남구", "용당동", "부경대 용당 캠퍼스", 12345 );
		PostVo vo2 = new PostVo("010-120", "부산", 
				"남구", "대연동", "부경대 대연 캠퍼스", 12340 );
		
		List<PostVo> postList = new ArrayList<>();
		postList.add(vo1);
		postList.add(vo2);
		
		HashMap<String, Object> newMap = new HashMap<String, Object>();
		newMap.put("data",postList);
		return newMap;
	}

}
