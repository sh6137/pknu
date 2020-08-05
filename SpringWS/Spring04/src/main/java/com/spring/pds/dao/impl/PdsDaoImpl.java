package com.spring.pds.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.pds.dao.PdsDao;
import com.spring.pds.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

@Repository("pdsDao")
public class PdsDaoImpl implements PdsDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void setWrite(HashMap<String, Object> map) {
		
		sqlSession.insert("PDS.PdsInsert", map);
		
	}

	@Override
	public List<PdsVo> getList(HashMap<String, Object> map) {
		
		sqlSession.selectList("PDS.PdsList", map);
		List<PdsVo> pdsList = (List<PdsVo>) map.get("result") ;
		//System.out.println( "recordcount:" + map.get("recordcount") );
		System.out.println("Dao" + pdsList);
		
		return pdsList;
	}

	@Override
	public PdsVo getContent(HashMap<String, Object> map) {
		
		sqlSession.selectList("PDS.PdsContent", map);
		List<PdsVo> pdsList = (List<PdsVo>) map.get("result");
		PdsVo       pdsVo   = pdsList.get(0);
	
		return pdsVo;
	}

	@Override
	public List<FilesVo> getFileList(HashMap<String, Object> map) {
		
		sqlSession.selectList("PDS.FileList", map);
		List<FilesVo> fileList =   (List<FilesVo>) map.get("result");
		
		return fileList;
	}

	@Override
	public void setUpdate(HashMap<String, Object> map) {
		
		sqlSession.insert("PDS.PdsUpdate", map);
	}
	
	

}
