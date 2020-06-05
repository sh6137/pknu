package com.pknu.member.view;

import java.util.List;

import com.pknu.member.dao.MemberDao;
import com.pknu.member.vo.MemberVO;

public class TestMain {
	public static void main(String[] args) {
		//개인조회
		MemberDao mDao = new MemberDao();
		MemberVO mem = mDao.getMember("seal");
		System.out.println(mem.info());
		
		//목록조회
		System.out.println("목록조회 : ");
		List<MemberVO> mList = mDao.getMemberList("가");
		for(MemberVO memberVO : mList) {
			System.out.println(memberVO.info());
		}
	}
}
