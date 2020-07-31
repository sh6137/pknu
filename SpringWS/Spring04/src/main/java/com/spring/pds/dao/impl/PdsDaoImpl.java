package com.spring.pds.dao.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.pds.dao.PdsDao;

@Repository("pdsDao")
public class PdsDaoImpl implements PdsDao{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void setWrite(HashMap<String, Object> map) {
		sqlSession.insert("PDS.PdsInsert",map);
	}

}
