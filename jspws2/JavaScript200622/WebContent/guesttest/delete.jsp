<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@
	page language="java" import = "java.sql.*"
%>

<%
	String strIDX = request.getParameter("idx");

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbUid = "testdb";
	String dbPwd = "1234";

	Class.forName("oracle.jdbc.driver.OracleDriver");
	//1. CONNECTION
	Connection conn = DriverManager.getConnection(url, dbUid, dbPwd); 
	
	//2. PreparedStatment
	String strSql ="DELETE FROM GUESTS WHERE IDX=?";
	PreparedStatement psmt = conn.prepareStatement(strSql);
	
	psmt.setString(1, strIDX);
	psmt.executeUpdate();

	String strSql2 = "update guests set idx = idx-1 where idx > ?";
	PreparedStatement psmt2 = conn.prepareStatement(strSql2);
	psmt2.setString(1, strIDX);
	psmt2.executeUpdate();		
			
	response.sendRedirect("./list.jsp");
			

%>