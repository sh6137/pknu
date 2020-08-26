package com.pknu.member.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pknu.member.dao.MemberDao;
import com.pknu.member.vo.MemberVo;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MemberVo> getList(HashMap<String, Object> map) {
		
		List<MemberVo> list  = sqlSession.selectList("Member.List", map); 
		
		return list;
	}

}
