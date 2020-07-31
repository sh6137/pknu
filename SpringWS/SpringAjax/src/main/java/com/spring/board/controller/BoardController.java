package com.spring.board.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.board.service.BoardService;
import com.spring.board.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	private BoardService  boardService; 
		
	@RequestMapping("/")
	public String home() {
		return "home";  // home.jsp
	}
	
	/*
	@RequestMapping("/a")
	public String html() {
		return "redirect:/static/html/test01.html";
	}
	
	@RequestMapping("/b")
	public String html2() {
		return "redirect:/static/html/test02.html";
	}
	*/
	
	@RequestMapping("/{value}")
	public String html(
		@PathVariable ("value") String val ) {
		String link = "";
		switch(val) {
		case "a":  // "/a"
			link = "redirect:/static/html/test01.html";
			break;
		case "b":  // "/b"
			link = "redirect:/static/html/test02.html";
			break;
		case "c":  // "/c"
			link = "redirect:/static/html/test03.html";
			break;
		case "d":  // "/c"
			link = "redirect:/static/html/test04.html";
			break;
		case "e":  // "/c"
			link = "redirect:/static/html/test05.html";
			break;
		}
		return  link;
	}
	
	//-------------------------------------------------
	
	@RequestMapping("/ajax")
	public void ajax(String v, HttpServletResponse response) {		
		String json = "{" + 
				"   \"id\":\"한글\"," + 
				"   \"pass\":\"1234\"," + 
				"   \"v\":\"" +  v +  "\"" + 
				"}";		
		
		try {		
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// {"pass":"blue","id":"sky"}
	// @ResponseBody : java 객체 -> json 문자열변경 
	@RequestMapping(value="/test1")
	@ResponseBody
	public Map<String, Object> test1(String id, String pass, String val) {
		Map<String, Object> map = new HashMap<String, Object> ();
		map.put("id",     id);
		map.put("pass",   pass);
		map.put("email",  val);
		return map;				
	}
	
	@RequestMapping("/ajax2")
	@ResponseBody
	public String test2() throws IOException {
		
		List<BoardVo> list = boardService.getList();
			
		
		// Jackson Library
		// java 객체 -> Json
		ObjectMapper  mapper = new ObjectMapper();
		String  jsonStr = mapper.writeValueAsString(list);
		System.out.println(jsonStr);
		
		// json -> java객체 [List<>]
		// String jsonStr2 = " {"num":"aaa", "name":"1234", "email":"a@b.c" }";
		// BoardVo board = mapper.readValue(jsonStr2, BoardVo.class);
		String jsonStr2  = "[" + 
				"  { \"num\":1, \"name\":\"a\", \"email\":\"a@naver.com\" }," + 
				"  { \"num\":2, \"name\":\"bc\", \"email\":\"bc@naver.com\" }" + 
				"]";
		List<BoardVo> boardList 
		 = mapper.readValue(jsonStr2, new TypeReference<List<BoardVo>>() {
		});
		System.out.println( boardList.get(0) );
		System.out.println( boardList.get(1) );
		
		return jsonStr;
	}
	//-------------------
	@RequestMapping(value = "/getMovieJson")
	@ResponseBody
	public String getMovieJson() throws IOException {
		BufferedInputStream reader = null;
		try {
		URL url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=794306f489b73e2728e234bc266fcd21&targetDt=20120101");
		reader = new BufferedInputStream(url.openStream());
		StringBuffer buffer = new StringBuffer();
		int i;
		byte [] b = new byte[4096];
		while((i=reader.read(b)) != -1) {
			buffer.append(new String(b,0,i));
		}
		return buffer.toString();
		}finally {
			if(reader !=null)
				reader.close();
		}
	}
	
}
 