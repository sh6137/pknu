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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;
import com.spring.pds.service.PdsService;
import com.spring.pds.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

@Controller

public class PdsController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private PdsService  pdsService;
	
	@RequestMapping("/PDS/List")
	public ModelAndView pdsList(
		@RequestParam  HashMap<String, Object> map	) {
		// /PDS/List?menu_id=MENU01&nowpage=1&pagecount=2&pagegrpnum=1
	    System.out.println("pdsList map:" + map);
	    
	    // MENU_ID : MENU01,  NOWPAGE : 1, PAGECOUNT: 5 
	    // pagegrpnum
	    
		List<PdsVo> pdsList   = pdsService.getList(map);
		PdsVo       pagePdsVo = (PdsVo) map.get("pagePdsVo");
		System.out.println("contr pdsList :" + pdsList); 
		
		ModelAndView mv = new ModelAndView();
		List<MenuVo> menuList = menuService.getList(map);		
		mv.addObject("menuList", menuList );     // 메뉴목록
		
		mv.addObject("pdsList",   pdsList );     // 게시물목록
		mv.addObject("pagePdsVo", pagePdsVo );   // 페이지 정보

		
		mv.setViewName("pds/list");
		
		System.out.println("pdsList() map:" + map);
		return  mv;
		
	}
	
	@RequestMapping("/PDS/WriteForm")
	public ModelAndView  writeForm(
		 @RequestParam	HashMap<String, Object> map) {	
		//{ menu_id:MENU01, bnum:0, lvl:0, step:0, nref:0, 
		// nowpage:1,pagegrpnum:1, user_id:'sky' } 
		
		System.out.println("writeForm" + map);
		List<MenuVo>  menuList = menuService.getList(map);
		
		// 로그인아이디
		map.put("user_id", "sky");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("menuList", menuList );
		mv.addObject("map",  map);  // request 정보들 + user_id
		mv.setViewName("pds/write");
		return  mv;
		
	}
	
	@RequestMapping("/PDS/Write") // 글쓰기
	public ModelAndView write(
		 @RequestParam	HashMap<String, Object> map,  // request 된 파라미터들
		 HttpServletRequest request  ) {              // file 정보받기	
		
		System.out.println("10:" + map);
		pdsService.setWrite(map, request);
		
		ModelAndView mv = new ModelAndView();
		
		List<MenuVo>  menuList = menuService.getList(map);
		mv.addObject("menuList", menuList );
		
		mv.addObject("menu_id",  map.get("menu_id"));		
		// 페이징관련 처리
		mv.addObject("nowpage",  map.get("nowpage"));
		mv.addObject("pagegrpnum",  map.get("pagegrpnum"));	
		mv.addObject("pagecount",  map.get("pagecount"));	
		
		mv.setViewName("redirect:/PDS/List");
		return mv;
		
	}
	
	// 내용보기
	@RequestMapping("/PDS/Content")
	public   ModelAndView   content(
			@RequestParam HashMap<String, Object> map) {
		// map : /PDS/Content?idx=9&menu_id=MENU01&nowpage=1&pagegrpnum=1
		
		System.out.println("content :" + map);
		
		List<MenuVo> menuList  =  menuService.getList(map);     // 메뉴조회
		PdsVo pdsVo            =  pdsService.getContent(map);            // Board 조회
		List<FilesVo> fileList =  pdsService.getFileList(map); // 파일목록(게시글의)
		
		ModelAndView  mv       = new ModelAndView();
		
		mv.addObject("menuList", menuList );  // 메뉴전체	  	
		mv.addObject("pdsVo", pdsVo );        // idx 해당 게시글  
		mv.addObject("fileList", fileList);   // 게시글의 파일목록  
		
		mv.addObject("nowpage",    map.get("nowpage" ) );
		mv.addObject("pagegrpnum", map.get("pagegrpnum") );
		
		mv.setViewName("pds/content");
				
		return   mv;
		
	} 
	
	@RequestMapping("/PDS/UpdateForm")
	public  ModelAndView  updateForm(
		@RequestParam HashMap<String, Object> map	) {
		
		List<MenuVo> menuList = menuService.getList(map);
		
		PdsVo pdsVo  = pdsService.getContent(map);
		
		ModelAndView  mv = new ModelAndView();
		
		mv.addObject("menuList", menuList );
		mv.addObject("pdsVo", pdsVo);
		
		mv.setViewName("pds/update");
		return mv;
	}  
	
	// 수정할 정보 저장
	@RequestMapping("/PDS/Update")
	public  ModelAndView  update(
			@RequestParam HashMap<String, Object> map,
			HttpServletRequest   request) {
		
	    pdsService.setUpdate( map );
		
		ModelAndView  mv = new ModelAndView();
		List<MenuVo>  menuList = menuService.getList(map);
		mv.addObject("menuList", menuList );
		
		mv.addObject("menu_id",  map.get("menu_id"));		
		// 페이징관련 처리
		mv.addObject("nowpage",  map.get("nowpage"));
		mv.addObject("pagegrpnum",  map.get("pagegrpnum"));	
		mv.addObject("pagecount",  map.get("pagecount"));	
		
		mv.setViewName("redirect:/PDS/List?pagecount=" +  map.get("pagecount")
		  +	"&nowpage=" + map.get("nowpage")
		  + "&pagegrpnum=" + map.get("pagegrpnum")
		  + "&menu_id=" +  map.get("menu_id") );
		return mv;
	}  
	
	
	//----------------------------------------------------------
	// 다운로드 소스
	// {sfile}     :   .jpg와같이 . 포함 글자는 무시된다
	// {sfile:.+}  :  정규식에서 확장자에 . 문자가 한개(+) 이상일때
	@RequestMapping(value="/download/{type}/{sfile:.+}",
			method = RequestMethod.GET)
	public void downloadFile( HttpServletResponse response,
			@PathVariable("type")  String type,
			@PathVariable("sfile") String sfile			
			) throws IOException {
		
		String INTERNAL_FILE        = sfile;
		String EXTERNAL_FILE_PATH   = "c:\\upload\\" +  sfile;
		
		File file = null;
		if(type.equalsIgnoreCase("internal") ) {
			ClassLoader classLoader
			   = Thread.currentThread().getContextClassLoader();
			file = new File(classLoader.getResource(INTERNAL_FILE).getFile());					
		} else {
			file = new File(EXTERNAL_FILE_PATH);
		}
		
		// 다른할 파일이 없습니다
		if(!file.exists()) {
			String errorMessage = "Sorry. the file are looking for does not exist";
			System.out.println(errorMessage);
		    OutputStream outputStream = response.getOutputStream();
		    outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
		    outputStream.close();
		    return;			
		}
		
		/* 브라우저에게 다운받을 파일의 type 을 알려준다
		 * 브라우저는 mimeType 에 따라 기능이 작동한다
		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if( mimeType == null ) {
			System.out.println("파일타입을 찾을 수 없습니다");
			mimeType = "application/octet-stream"; 
		} */
		String mimeType = "application/octet-stream"; // 무조건 다운로드
		System.out.println("mimeType:" + mimeType);
		
		// 다운로드 로직
		response.setContentType(mimeType);
		
		response.setHeader("Content-Dispostition", 
			 String.format("inline; filename=\"" + file.getName() + "\""));
		
		response.setContentLength((int)file.length());
		
		InputStream inputStream = new BufferedInputStream(
			new FileInputStream(file) );
		
		// Copy bytes from source to destination(outputStream)
		//   close both streams
		FileCopyUtils.copy(inputStream, response.getOutputStream());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
