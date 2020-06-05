package com.pknu.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Singleton pattern
//객체가 한번만 인스턴스를 만든다 : 한번만 new 할수 있다.
public class DBConn {
	
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url    = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String dbuid  = "member2";
	private static String dbpwd  = "1234";
	
	private static Connection conn;
	//생성자
	private DBConn() {
		
	}
	public static Connection getInstance() {
		return getConnection();
	}
	private static Connection getConnection() {
		//기존에 new 되어있는 conn 객체가 있으면 conn 객체를 리턴하고 종료
		if(conn != null)
			return conn;
		//기존 conn 객체가 new 되지 않으면
		
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url,dbuid,dbpwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
}
