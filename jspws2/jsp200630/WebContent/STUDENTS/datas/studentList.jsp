<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page language="java" import="PKG_DB.DBCon" %>
<%@ page language="java" import="java.sql.*" %>
 <%@ page language="java" import="org.json.simple.JSONArray" %>
 <%@ page language="java" import="org.json.simple.JSONObject" %>

<%

/*
	DBCon dbCon = new DBCon();
	dbCon.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	dbCon.setUserID("lje");
	dbCon.setUserPwd("1");
*/

	DBCon dbCon = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "testdb", "1234");

	String strSql = "SELECT SID, SNAME, DAGE FROM STUDENTS ORDER BY SID DESC";
	
	//Connection con = dbCon.getConnection();
	ResultSet rs = dbCon.getResultSet(strSql);
	
	JSONArray arr = new JSONArray();
	
	while(rs.next()){
		
		JSONObject obj = new JSONObject();
		obj.put("sid", rs.getString("SID"));
		obj.put("sname", rs.getString("SNAME"));
		obj.put("sage", rs.getString("DAGE"));
		
		arr.add(obj);
		
	}
	
	response.setContentType("application/json");
	out.println(arr);

%>