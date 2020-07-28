<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import = "java.sql.*" %>
<%@ page language="java" import = "org.json.simple.JSONArray" %>
<%@ page language="java" import = "org.json.simple.JSONObject" %>
<%
String url = "jdbc:oracle:thin:@localhost:1521:XE";
String user = "testdb";
String pwd = "1234";

Class.forName("oracle.jdbc.driver.OracleDriver");

Connection conn = DriverManager.getConnection(url, user, pwd);
	

String strSQL = "SELECT USERID, USERNAME, USERPASS FROM MEMBERS ORDER by USERID ASC";
PreparedStatement psmt = conn.prepareStatement(strSQL);

ResultSet rs = psmt.executeQuery();

JSONArray arr = new JSONArray();

while(rs.next()){
	JSONObject obj = new JSONObject();
	obj.put("userid",rs.getString("USERID"));
	obj.put("username",rs.getString("USERNAME"));
	
	arr.add(obj);
}
response.setContentType("application/json");
out.println(arr);
%>