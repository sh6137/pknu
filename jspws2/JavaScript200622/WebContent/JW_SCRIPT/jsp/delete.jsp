<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language = "java" import = "java.sql.*" %>
    
<!DOCTYPE html>
<%
	String delsid = request.getParameter("delsid");

	//out.print(delsid);
	
	//0.오라클을 연결하려면 오라클 연결정보
	//String driver = "oracle.jdbc.OracleDriver";
   String url = "jdbc:oracle:thin:@localhost:1521:xe";
   String dbUid = "testdb";
   String dbPwd = "1234";
   
   //1. db연결을 위한 class
   Connection conn = DriverManager.getConnection(url, dbUid, dbPwd); 
   String strSql = "DELETE FROM STUDENTS WHERE SID IN " +delsid;

   PreparedStatement pstmt = conn.prepareStatement(strSql);

   pstmt.executeUpdate();
   
   response.sendRedirect("./list.jsp?sname=");
   
%>