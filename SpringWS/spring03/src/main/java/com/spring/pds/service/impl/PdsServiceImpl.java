package com.spring.pds.service.impl;

import java.io.File;
import java.io.IOException;
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
import com.spring.pds.vo.PdsVo;

@Service("pdsService")
public class PdsServiceImpl implements PdsService  {

	@Autowired
	private  PdsDao  pdsDao; 
	
	@Override
	public List<PdsVo> getPdsList(HashMap<String, Object> map) {
				
		List<PdsVo> pdsList  = pdsDao.getPdslist(map);
		return      pdsList;
		
	}

	@Override
	public void setWrite(HashMap<String, Object> map, HttpServletRequest request) {
		//파일 저장(기존파일존재하면 파일명 변경)
		CheckFileName checkFile	=new CheckFileName();
		
		//업로드된 파일이 저장될 경로 지정
		String filePath="c:\\upload\\";
		
		MultipartHttpServletRequest multipartHttpServletRequest 
		= (MultipartHttpServletRequest) request;
		
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		
		MultipartFile multipartFile = null;
		
		String fileName = null;
		String orgFileName = null;
		String fileExt = null;
		String sFileName = null;
		
		while(iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			
			if(!multipartFile.isEmpty()) {
				fileName = multipartFile.getOriginalFilename();
				//spring01.hwp
				orgFileName = fileName.substring(0,fileName.lastIndexOf("."));
				//spring01
				fileExt = fileName.substring(fileName.lastIndexOf("."));
				//.hwp
				
				//fileName 을 저장된 폴더에서 중복된 파일 
				sFileName = checkFile.getFileName(filePath, orgFileName, fileExt);
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
		
		map.put("filename", fileName);
		map.put("fileext", fileExt);
		map.put("sfilename", sFileName);
		
		pdsDao.setWrite(map);
		
	}//setWrite end

	@Override
	public List<PdsVo> getView(HashMap<String, Object> map) {
		
		List<PdsVo> pdsList =  pdsDao.getView(map);
		return pdsList;
	}

}
