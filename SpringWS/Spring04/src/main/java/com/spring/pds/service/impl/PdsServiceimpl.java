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

import com.spring.menu.vo.MenuVo;
import com.spring.pds.dao.PdsDao;
import com.spring.pds.service.PdsService;
import com.spring.pds.vo.PdsVo;

@Service("pdsService")

public class PdsServiceimpl implements PdsService {
	@Autowired
	private PdsDao pdsDao;

	@Override
	public void setWrite(HashMap<String, Object> map, HttpServletRequest request) {
		//1. 파일 업로드 비지니스 로직 처리
		CheckFileName checkFile = new CheckFileName();
		
		MultipartHttpServletRequest multipartServletRequest
		 =(MultipartHttpServletRequest)request;
		
		Iterator<String> iterator = multipartServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		
		List<String> filenames = new ArrayList<String>();
		List<String> fileexts = new ArrayList<String>();
		List<String> sfilenames = new ArrayList<String>();
		
		String fileName = null;
		String orgFileName = null;
		String fileExt = null;
		String sFileName = null;
		String filePath="c:\\upload\\"; //파일저장위치
		
		while(iterator.hasNext()) {
			multipartFile = multipartServletRequest.getFile(iterator.next());
			
			if(!multipartFile.isEmpty()) {
				fileName = multipartFile.getOriginalFilename();
				//spring01.hwp
				orgFileName = fileName.substring(0,fileName.lastIndexOf("."));
				//spring01
				fileExt = fileName.substring(fileName.lastIndexOf("."));
				//.hwp
				
				//fileName 을 저장된 폴더에서 중복된 파일 
				sFileName = checkFile.getFileName(filePath, orgFileName, fileExt);
				
				//바뀜
				filenames.add(fileName);
				fileexts.add(fileExt);
				sfilenames.add(sFileName);
				
				map.put("filenames", filenames);
				map.put("fileexts", fileexts);
				map.put("sfilenames", sfilenames);
				
				File file = new File(filePath + sFileName);
				
				try {
					multipartFile.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} // if end
		} //while end
		
		//2.db 저장
		pdsDao.setWrite(map);
	}

	@Override
	public List<PdsVo> getList(HashMap<String, Object> map) {
		
		int pagetotalcount = 10;
		int pagecount = 2;
		
		List<PdsVo> pdsList = pdsDao.getList(map);
		return null;
		
	}
}
