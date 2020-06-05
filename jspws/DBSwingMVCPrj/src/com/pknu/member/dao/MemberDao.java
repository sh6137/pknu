package com.pknu.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.pknu.member.vo.MemberVO;

public class MemberDao {
	private  Connection          conn;
	private  PreparedStatement   pstmt;
	private  ResultSet           rs;
	
	// 생성자
	public  MemberDao() { }
	
	// 메소드
	private  void  close() {
		try {
			if( rs      != null )  rs.close();
			if( pstmt   != null )  pstmt.close();
			if( conn    != null )  conn.close();
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	} 
	
	// 조회
	// 한 회원의 정보만 보여줌
	public  MemberVO   getMember(String  userid) {
		MemberVO  mem = null;
		
		try {
			conn        =  DBConn.getInstance();
			String sql  =  "SELECT  id, pwd, name, job, gender, intro, regdate"; 
			sql        +=  " FROM    member2" ; 
			sql        +=  " where   id = ? ";
			pstmt      =  conn.prepareStatement(sql);
			pstmt.setString(1,  userid);;
			rs         =  pstmt.executeQuery();
			if( rs.next() ) {
				/*
				String  id        =  rs.getString("id");
				String  pwd       =  rs.getString("pwd");
				String  name      =  rs.getString("name");
				String  job       =  rs.getString("job");
				String  gender    =  rs.getString("gender");
				String  intro     =  rs.getString("intro");
				String  regdate   =  rs.getString("regdate");
				mem  =  new MemberVO(id, pwd, name, job, gender, intro, regdate);
				*/
				String [] cols = new String[7];
				for (int i = 0; i < cols.length; i++) {
					cols[i] = rs.getString( i+1 );							
				}
				mem = new MemberVO( cols );
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//close();
		} 		
		
		return    mem;
	}


	/* swing 쪽에서는 수정필요	DefaultDataModel 은 genecric을 인식하지못함
	public Vector<MemberVO> getMemberList(String search_name) {
		Vector<MemberVO> mList = new Vector<MemberVO>();
		
		try {
			conn       = DBConn.getInstance();  
			String sql =  "SELECT ID, PWD, NAME, JOB, GENDER, INTRO, REGDATE ";
			sql       +=  " FROM   MEMBER2 ";
			sql       +=  " WHERE  NAME  LIKE ? ";   // Like '%석%'
			pstmt      =  conn.prepareStatement(sql);
			pstmt.setString(1, "%" + search_name + "%" );
			rs         =  pstmt.executeQuery();
			while( rs.next()) {
				String id        =  rs.getString("id");
				String pwd       =  rs.getString("pwd");
				String name      =  rs.getString("name");
				String job       =  rs.getString("job");
				String gender    =  rs.getString("gender");
				String intro     =  rs.getString("intro");
				String regdate   =  rs.getString("regdate");				
				MemberVO mem  = new MemberVO(id, pwd, name, job, gender, intro, regdate); 
				mList.add( mem );
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return mList;
	}
	*/
	
	// swing용 
	public Vector   getMemberList(String search_name) {
		Vector    mList = new Vector();
		
		try {
			conn       = DBConn.getInstance();  
			String sql =  "SELECT ID, PWD, NAME, JOB, GENDER, INTRO, REGDATE ";
			sql       +=  " FROM   MEMBER2 ";
			sql       +=  " WHERE  NAME  LIKE ? ";   // Like '%석%'
			pstmt      =  conn.prepareStatement(sql);
			pstmt.setString(1, "%" + search_name + "%" );
			rs         =  pstmt.executeQuery();
			while( rs.next()) {
				String id        =  rs.getString("id");
				String pwd       =  rs.getString("pwd");
				String name      =  rs.getString("name");
				String job       =  rs.getString("job");
				String gender    =  rs.getString("gender");
				String intro     =  rs.getString("intro");
				String regdate   =  rs.getString("regdate");				
				
				Vector   mem  = new Vector(); 
				mem.add(id);
				mem.add(pwd);
				mem.add(name);
				mem.add(job);
				mem.add(gender);
				mem.add(intro);
				mem.add(regdate); 
							
				mList.add( mem );
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return mList;
	}

	public boolean insertMember(MemberVO mem) {
		int cnt =0;
		try {
			conn = DBConn.getInstance();
			String sql ="INSERT INTO member2 (id,  pwd,  name, job, gender, intro) " + 
						" VALUES(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPwd());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getJob());
			pstmt.setString(5, mem.getGender());
			pstmt.setString(6, mem.getIntro());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean ok = (cnt ==0)? false : true;
		return ok;
	}
	
	public boolean deleteMember(MemberVO mem) {
		int cnt = 0;
		try {
			conn = DBConn.getInstance();
			String sql = "delete from member2 where name like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getName());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean ok = (cnt ==0)? false : true;
		return ok;
	}

	public boolean updateMember(MemberVO mem) {
		int cnt = 0;
		try {
			conn = DBConn.getInstance();
			String sql = "";
			pstmt = conn.prepareStatement(sql);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean ok = (cnt ==0)? false : true;
		return ok;
	}
	
	
	
	
	
	
	
	
	
	
	
}
