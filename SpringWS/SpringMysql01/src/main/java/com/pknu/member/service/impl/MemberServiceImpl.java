package com.pknu.member.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu.member.dao.MemberDao;
import com.pknu.member.service.MemberService;
import com.pknu.member.vo.MemberVo;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public List<MemberVo> getList(HashMap<String, Object> map) {
		List<MemberVo> list  = memberDao.getList(map);
		return  list;
	}

}
