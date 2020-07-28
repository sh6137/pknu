<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language = "java" import = "java.sql.*" %>


<%
	String strName = request.getParameter("name");
	String strContents = request.getParameter("contents");
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbUid = "testdb";
	String dbPwd = "1234";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//1. CONNECTION
	Connection conn = DriverManager.getConnection(url, dbUid, dbPwd); 
	
	String iSql = "SELECT NVL(MAX(IDX), 0) + 1 AS NEWIDX FROM GUESTS";
	PreparedStatement isPmt = conn.prepareStatement(iSql);
	
	ResultSet iRs = isPmt.executeQuery();
	iRs.next();
	System.out.println(iRs);
	
	String strIdx = iRs.getString("NEWIDX");
	out.println(strIdx);
	
	String strSql = "INSERT INTO GUESTS(IDX, NAME, CONTENTS, REGDATE) VALUES(?,?,?,SYSDATE)";
	PreparedStatement psmt = conn.prepareStatement(strSql);
	psmt.setString(1, strIdx);
	psmt.setString(2, strName);
	psmt.setString(3, strContents);
	
	psmt.executeUpdate();
	
	response.sendRedirect("./list.jsp");
%>