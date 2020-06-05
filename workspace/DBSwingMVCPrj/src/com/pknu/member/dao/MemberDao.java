package com.pknu.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.pknu.member.vo.MemberVO;

public class MemberDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//생성자
	public MemberDao() {
		
	}
	//메소스
	private void close() {
		try {
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//조회
	//한 회원의 정보만 보여줌
	public MemberVO getMember(String userid) {
		MemberVO mem = null;
		
		
		try {
			conn = DBConn.getInstance();
			String sql="select ID, PWD, NAME, JOB, GENDER, INTRO, REGDATE from member2"
					+ " where id = ?" ;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
//				String id = rs.getString("id");
//				String pwd = rs.getString("pwd");
//				String name = rs.getString("name");
//				String job = rs.getString("job");
//				String gender = rs.getString("gender");
//				String intro = rs.getString("intro");
//				String regdate = rs.getString("regdate");
//				mem=new MemberVO(id, pwd, name, job, gender, intro, regdate);
				
				String [] cols = new String[7];
				for(int i =0 ; i< cols.length; i++) {
					cols[i] = rs.getString(i+1);
				}
				mem = new MemberVO(cols);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mem;
	}
	public List<MemberVO> getMemberList(String serach_name) {
		List<MemberVO> mList = new Vector<MemberVO>();
		
		try {
			conn = DBConn.getInstance();
			String sql="SELECT ID,PWD,NAME,JOB,GENDER,INTRO,REGDATE"
					+ " FROM MEMBER2 "
					+ " WHERE NAME LIKE ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' + serach_name +'%');
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String job = rs.getString("job");
				String gender = rs.getString("gender");
				String intro = rs.getString("intro");
				String regdate = rs.getString("regdate");
				MemberVO mem = new MemberVO(id,pwd,name,job,gender,intro,regdate);
				mList.add(mem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}
	
}
