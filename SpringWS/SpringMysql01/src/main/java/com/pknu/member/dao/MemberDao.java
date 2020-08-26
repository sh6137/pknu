package com.pknu.member.dao;

import java.util.HashMap;
import java.util.List;

import com.pknu.member.vo.MemberVo;

public interface MemberDao {

	List<MemberVo> getList(HashMap<String, Object> map);

}
