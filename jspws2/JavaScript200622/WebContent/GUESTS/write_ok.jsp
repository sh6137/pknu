<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language = "java" import = "java.sql.*" %>
 
<%
	//0. client 보낸 데이터를 받아야 한다.
	String strName = request.getParameter("name");
	String strContents = request.getParameter("contents");
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbUid = "testdb";
	String dbPwd = "1234";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//1. CONNECTION
	Connection conn = DriverManager.getConnection(url, dbUid, dbPwd); 

	//2. PreparedStatment
	String iSql ="SELECT NVL(MAX(IDX), 0) + 1 AS NEWIDX FROM GUESTS";
	PreparedStatement iPsmt = conn.prepareStatement(iSql);
	
	ResultSet iRs = iPsmt.executeQuery();
	iRs.next();
	
	
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