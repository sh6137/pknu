package com.spring.pds.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.pds.dao.PdsDao;
import com.spring.pds.vo.PdsVo;

@Repository("pdsDao")
public class PdsDaoImpl implements PdsDao{
	@Autowired
	private SqlSession sqlSession;
	@Override
	public List<PdsVo> getPdsList(HashMap<String, Object> map) {
		sqlSession.selectList("PDS.PdsList",map);
		List<PdsVo> pdsList = (List<PdsVo>) map.get("result");
		return pdsList;
	}

}
