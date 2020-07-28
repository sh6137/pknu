<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page language = "java" import = "java.sql.*" %>

<%
   //데이터 받기
   String strId = request.getParameter("id");
   String strName= request.getParameter("name");
   String strAge = request.getParameter("age");
   String strGender = request.getParameter("gender");
   String strHobby = request.getParameter("hobby");
   
   out.print(strId);
   
   //DB table에 데이터 넣기
   //DB 연동시 사용하는 java package -> java.sql
   
   //0.오라클 연결정보
   //String driver = "oracle.jdbc.OracleDriver";
   String url = "jdbc:oracle:thin:@localhost:1521:xe";
   String dbUid = "testdb";
   String dbPwd = "1234";
   
   //1. db연결을 위한 class
   Connection conn = DriverManager.getConnection(url, dbUid, dbPwd); 
   
   //2. PreparedStatement class
   String strSql = "insert into students(sid, sname, did, dage, dgen) values(?, ?, ?, ?, ?)";
   PreparedStatement psmt = conn.prepareStatement(strSql);
   psmt.setString(1, strId);
   psmt.setString(2, strName);
   psmt.setString(3, "D001");
   psmt.setString(4, strAge);
   psmt.setString(5, strGender);
   
   psmt.executeUpdate();
   response.sendRedirect("./list.jsp");
   
%>