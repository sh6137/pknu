package com.pknu.member.view;

import java.util.List;
import java.util.Vector;

import com.pknu.member.dao.MemberDao;
import com.pknu.member.vo.MemberVO;

public abstract class TestMain {

	public static void main(String[] args) {
	
		
		// 개인조회
		MemberDao      mDao  =  new MemberDao();
		MemberVO       mem   =  mDao.getMember("sea1");
		System.out.println("===== 개인조회 ======");
		System.out.println( mem.info() );
		
		// 목록 조회
//		System.out.println("==== 목록조회:" + "'석' 포함된 ====");
//		List<MemberVO> mList  = mDao.getMemberList("석"); 
//		for (MemberVO memberVO : mList) {
//			System.out.println(  memberVO.info() );
//		}
		
		System.out.println("==== 목록조회:" + "'석' 포함된 ====");
		Vector    mList  = mDao.getMemberList("석"); 
		for (int i = 0; i < mList.size(); i++) {
			Vector v = (Vector) mList.get(i);
			for (int j = 0; j < v.size(); j++) {
				System.out.print( (String) v.get( j ) +  " " );
			}
			System.out.println();
		}

		
	}

}
