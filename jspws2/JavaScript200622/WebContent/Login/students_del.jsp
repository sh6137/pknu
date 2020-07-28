<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language = "java" import = "java.sql.*"%>
<%@ page language = "java" import = "org.json.simple.*"%>

<%
   String strUserId = request.getParameter("params");
 
   String url = "jdbc:oracle:thin:@localhost:1521:xe";
   String dbUid = "testdb";
   String dbPwd = "1234";
   
   Class.forName("oracle.jdbc.driver.OracleDriver");
   
   Connection conn = DriverManager.getConnection(url, dbUid, dbPwd);
   
   String strSql = "delete from members where userid in" + strParams;
   
   PreparedStatement psmt = conn.prepareStatement(strSql);
   
   
   psmt.executeUpdate();
   response.setContentType("Application/json");//그냥 보내면 html로 인식하므로 json타입으로 보내기 위해

%>