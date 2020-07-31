package com.spring.pds.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;
import com.spring.pds.service.PdsService;
import com.spring.pds.vo.PdsVo;

@Controller
public class PdsController {
	
	@Autowired
	private PdsService pdsService;
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/PDS/List")
	public ModelAndView pdsList(PdsVo vo) {
		// Board + Files 조회 : menu_id 에 해당되는 
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("menu_id", vo.getMenu_id());
		
		List<PdsVo> pdsList = pdsService.getPdsList(map); //조회시 사용할 map 안에 menu_id 를 넣어준다.
		
		// Menus  조회
		List<MenuVo> menuList = menuService.getList(map); //menu_id  전달됨
				
		// list.jsp 위한 준비
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pds/list");
		mv.addObject("menuList", menuList); //전체 메류초회
		mv.addObject("pdsList", pdsList); //조회된글
		mv.addObject("menu_id",  vo.getMenu_id()); //조회된글
		
		return mv;		
	}
	
	@RequestMapping("/PDS/WriteForm")
	public ModelAndView writeForm(PdsVo vo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<MenuVo> menuList = menuService.getList(map);
		ModelAndView mv = new ModelAndView(); 
		
		mv.addObject("menuList",menuList);
		mv.addObject("menu_id",vo);
		
		mv.setViewName("pds/write");
		return mv;
		
	}
	
	@RequestMapping("/PDS/Write")
	public ModelAndView write(PdsVo vo, HttpServletRequest request) {
		System.out.println("write pdsVo : "+vo);
		
		//글 저장
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("menu_id", vo.getMenu_id());
		map.put("writer", vo.getWriter());
		map.put("title", vo.getTitle());
		map.put("cont", vo.getCont());
		map.put("bnum", vo.getBnum());
		map.put("lvl", vo.getLvl());
		map.put("step", vo.getStep());
		map.put("nref", vo.getNref());
		
		System.out.println(request);
		pdsService.setWrite(map,request);
		//저장 이후 처리
		ModelAndView mv = new ModelAndView();
		List<MenuVo> menuList = menuService.getList(map);
		mv.addObject("menu_id",vo.getMenu_id());
		mv.addObject("menuList",menuList);
		
		mv.setViewName("redirect:/PDS/List");
		return mv;
		
	}
	
	@RequestMapping("/PDS/View") // /PDS/View?idx=1
	public ModelAndView view(PdsVo pdsVo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("idx", pdsVo.getIdx());
		List<PdsVo> voList = pdsService.getView(map);
		ModelAndView mv = new ModelAndView();
		List<MenuVo> menuList = menuService.getList(map);
		mv.addObject("menuList",menuList);
		mv.addObject("pdsVo", voList.get(0));
		mv.setViewName("pds/content");
		return mv;
	}
	
	// {sfile} : .jpg와 같이 . 포함글자는 무시
	// {sfile : .+} : 정규식에서 확장자에 . 문자 한개 (+) 이상일때
	   @RequestMapping(value="/download/{type}/{sfile:.+}", method=RequestMethod.GET)
	   public void downloadFile(HttpServletResponse response, @PathVariable("type") String type, @PathVariable("sfile") String sfile) throws IOException {
	      String INTERNAL_FILE      = sfile;
	      String EXTERNAL_FILE_PATH    = "c:\\upload\\" + sfile;
	      System.out.println("------------------------------");
	      System.out.println(EXTERNAL_FILE_PATH);
	      File file = null;
	      if(type.equalsIgnoreCase("internal")) {
	         ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	      file = new File(classLoader.getResource(INTERNAL_FILE).getFile());
	      } else {
	         file = new File(EXTERNAL_FILE_PATH);
	      }
	      
	      // 다운 할 파일이 없습니다
	      if(!file.exists() ) {
	         String errorMessage = "Sorry. the file are looking for does not exist!";
	         System.out.println(errorMessage);
	         OutputStream outputStream = response.getOutputStream();
	         outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
	         outputStream.close();
	         return;
	      }
	      
	      /* 브라우저에게 다운 받을 파일의 type을 알려준다(알려줌으로써 원래 타입을 바꿔버림)
	       * 브라우저는 mimeType에 따라 기능이 작동한다
	      String mimeType = URLConnection.guessContentTypeFromName(file.getName());
	      if (mimeType == null) {
	         System.out.println("파일 타입을 찾을 수 없습니다");
	         mimeType = "application/octet-stream";   
	      }
	       mimeType = "application/octet-stream";// 무조건 다운로드*/
	      String mimeType = "application/octet-stream";// 무조건 다운로드
	      System.out.println("mimeType : " + mimeType);
	      
	      // 다운로드 로직
	      response.setContentType(mimeType);
	      response.setHeader("Content-Dispostition", String.format("inline; filename=\"" + file.getName() + "\""));
	      
	      response.setContentLength((int)file.length());
	      
	      InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
	      
	      FileCopyUtils.copy(inputStream, response.getOutputStream());
	   }
}
