package com.pknu.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.pknu.user.dao.UserDao;
import com.pknu.user.vo.UserVo;
@Component
public class UserDaoImpl implements UserDao{
	// Field
	private DataSource dataSource;
	// Setter
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void addUser(UserVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql ="INSERT INTO SIMPLE_MEM VALUES(?,?)";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.executeUpdate();
			pstmt.close();
			
			System.out.println(vo.getName() + "이 저장되었습니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public List<UserVo> getList() {
		List<UserVo> list = new ArrayList();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String sql ="SELECT NAME, TEL FROM SIMPLE_MEM ";
			sql +="ORDER BY NAME ASC ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVo vo = new UserVo();
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				
				list.add(vo);
				System.out.println("이름"+vo.getName());
				System.out.println("번호"+vo.getTel());
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	@Override
	public UserVo getView(String tel) {
		UserVo vo = null;
		
		Connection					conn = null;
		PreparedStatement 			pstmt = null;
		ResultSet 					rs = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "select name,tel from simple_mem";
			sql+= " where tel=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tel);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo=new UserVo();
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return vo;
	}
	@Override
	public UserVo getDelete(String tel) {
		UserVo vo = null;
		
		Connection					conn = null;
		PreparedStatement 			pstmt = null;
		ResultSet 					rs = null;
		
		try {
			conn = dataSource.getConnection();
			//DELETE FROM simple_mem WHERE tel = '010-9090-5678';
			String sql = "delete from simple_mem";
			sql+= " where tel=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tel);
			rs = pstmt.executeQuery();
			
			rs.close();
			pstmt.close();
			conn.close();
			if(rs.next()) {
				vo=new UserVo();
				/*
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				*/
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return vo;
		
	}
	@Override
	public void updateUser(UserVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "UPDATE SIMPLE_MEM ";
			sql+="SET NAME = ? ";
			sql+="WHERE TEL = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			System.out.println("수정되었습");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
//	//UPDATE simple_mem SET name = '설현DL', TEL ='01001010' WHERE TEL='010-2340-5678';
//	@Override
//	public void getUpdate(UserVo vo) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			conn = dataSource.getConnection();
//			String sql ="UPDATE simple_mem SET name = ? , TEL =? "
//					+ "WHERE TEL=? ";
//			pstmt =conn.prepareStatement(sql);
//			pstmt.setString(1, vo.getName());
//			pstmt.setString(2, vo.getTel());
//			pstmt.setString(3, vo.getName());
//			pstmt.executeUpdate();
//			pstmt.close();
//			
//			System.out.println(vo.getName() + "이 저장되었습니다.");
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//	}
	
	
}
