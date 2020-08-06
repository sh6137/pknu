package com.spring.pds.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.pds.dao.PdsDao;
import com.spring.pds.service.PdsService;
import com.spring.pds.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

@Service("pdsService")
public class PdsServiceImpl implements PdsService {

	@Autowired
	private PdsDao pdsDao;
	
	@Override
	public void setWrite(HashMap<String, Object> map, HttpServletRequest request) {
		//1. 파일업로드 비지니스 로직 처리
		CheckFileName checkFile = new CheckFileName();
		
		MultipartHttpServletRequest  multipartServletRequest
		  = (MultipartHttpServletRequest) request;
		
		Iterator<String> iterator      =  multipartServletRequest.getFileNames();
		MultipartFile    multipartFile =  null;
		
		List<String> filenames  = new ArrayList<String>();
		List<String> fileexts   = new ArrayList<String>();
		List<String> sfilenames = new ArrayList<String>();
		
		String  fileName    =  null;
		String  orgFileName =  null;
		String  fileExt     =  null;
		String  sFileName   =  null;
		
		String filePath  = "c:\\upload\\";   // 파일저장위치
		
		int i = 0;
		while( iterator.hasNext() ) { // 자료가 있는지를 판단
			multipartFile = multipartServletRequest.getFile( iterator.next() );
			
			if( !multipartFile.isEmpty() ) {
				fileName    = multipartFile.getOriginalFilename();				
				orgFileName = fileName.substring(0, fileName.lastIndexOf("."));				
				fileExt     = fileName.substring(fileName.lastIndexOf("."));						
				
				sFileName    = checkFile.getFileName(
						filePath, orgFileName, fileExt);
				
				// 바뀜
				
				filenames.add(fileName);    // arraylist 에 추가
				fileexts.add(fileExt);      // arraylist 에 추가
				sfilenames.add(sFileName);  // arraylist 에 추가
				
				map.put("filenames",  filenames);
				map.put("fileexts",   fileexts);
				map.put("sfilenames", sfilenames);
				
				// 저장
				File file = new File(filePath + sFileName);
				i += 1;
				try {
					multipartFile.transferTo( file ); // 실제파일명으로 저장
				} catch(IOException e) {
					System.out.println("오류:" + e.getMessage()); 
					e.printStackTrace();
				}				
			}  // if end
		} // while end		
				
		// 2. db 저장
		pdsDao.setWrite( map );

	}

	@Override
	public List<PdsVo> getList(HashMap<String, Object> map) {
		
		System.out.println("1:" + map);
		
		int  pagetotalcount  = 3;     // [이전] 1 2 3 4 5 6 7 8 9 10 [다음] : 10
		int  pagecount       = Integer.valueOf( (String) map.get("pagecount") );  // 한페이지당 2 line
				
		List<PdsVo> pdsList  = pdsDao.getList( map );
		System.out.println();
		
		int nowpage     =  Integer.valueOf( (String) map.get("nowpage") );
		int pagegrpnum  =  Integer.valueOf( (String) map.get("pagegrpnum"));
		
		int recordcount =   (int) map.get("recordcount"); 
		   // 전체 자료수 PKG_PDS.PROC_PDS_LIST :  out_recordcount
		
		BoardPaging  bp = new BoardPaging( 
			nowpage, pagecount, recordcount, pagetotalcount, pagegrpnum );
		
		PdsVo        vo = bp.getPdsPagingInfo();
		vo.setMenu_id((String) map.get("menu_id"));
		
		map.put("pagePdsVo", vo);
		
		return pdsList;
	}

	@Override
	public PdsVo getContent(HashMap<String, Object> map) {
		
		PdsVo pdsVo = pdsDao.getContent(map);
		
		return  pdsVo;
	}

	@Override
	public List<FilesVo> getFileList(HashMap<String, Object> map) {
		
		List<FilesVo> fileList = pdsDao.getFileList(map);
		
		return    fileList;
	}

	@Override
	public void setUpdate(HashMap<String, Object> map) {

		pdsDao.setUpdate(map);
		
	}

	@Override
	public void setDelete(HashMap<String, Object> map) {
		
		pdsDao.setDelete( map );
		
		
	}

}
