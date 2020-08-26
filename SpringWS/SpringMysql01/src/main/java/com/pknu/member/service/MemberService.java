package com.pknu.member.service;

import java.util.HashMap;
import java.util.List;

import com.pknu.member.vo.MemberVo;

public interface MemberService {

	List<MemberVo> getList(HashMap<String, Object> map);

}
