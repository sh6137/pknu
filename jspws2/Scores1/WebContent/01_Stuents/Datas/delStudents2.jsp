<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="PKG_DB.DBCon" %>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="org.json.simple.*" %>
<%@ page language="java" import="org.json.simple.parser.JSONParser" %>


<%
	String strStu_ids = "[{\"stu_id\":\"STU093\"},{\"stu_id\":\"STU092\"}]"; //request.getParameter("sendData");
	
	JSONParser parse = new JSONParser();
	
	JSONArray arr = (JSONArray)parse.parse(strStu_ids);
	
	 
	for(int i=0;i<arr.size();i++){
		
		
		
	}
	
	

%>