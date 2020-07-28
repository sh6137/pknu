<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import = "java.sql.*" %>
<%@ page language="java" import = "org.json.simple.JSONArray" %>
<%@ page language="java" import = "org.json.simple.JSONObject" %>
    
<%
String url = "jdbc:oracle:thin:@localhost:1521:XE";
String user = "testdb";
String pwd = "1234";

Connection conn = DriverManager.getConnection(url, user, pwd);
Class.forName("oracle.jdbc.driver.OracleDriver");	

String strSql = "SELECT SID, SNAME FROM STUDENTS ORDER BY SID ASC";
PreparedStatement psmt = conn.prepareStatement(strSql);

ResultSet rs = psmt.executeQuery();
JSONArray arr = new JSONArray();

while(rs.next()){
	JSONObject obj = new JSONObject();
	obj.put("sid",rs.getString("SID"));
	obj.put("sname",rs.getString("SNAME"));
	
	arr.add(obj);
}
response.setContentType("Application/json");
out.println(arr);

%>