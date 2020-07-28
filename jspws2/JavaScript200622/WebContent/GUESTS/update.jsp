<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ page language="java" import="java.sql.*"%>

   <%
   		String strIDX = request.getParameter("hIdx");
   		String strContents = request.getParameter("hContents");
   		
   		Class.forName("oracle.jdbc.driver.OracleDriver");
   		
   	 	String url = "jdbc:oracle:thin:@localhost:1521:XE";
   		String user = "testdb";
   		String pwd = "1234";
   		
   		//1. CONNECTION 
   		Connection con = DriverManager.getConnection(url, user, pwd); 
   	 
   		String strSql = "UPDATE GUESTS SET CONTENTS=? WHERE IDX=?";
   		PreparedStatement psmt = con.prepareStatement(strSql);
   		
   		psmt.setString(1, strContents);
   		psmt.setString(2, strIDX);
   		
   		psmt.executeUpdate();
   		
   		response.sendRedirect("./list.jsp");
   
   %>