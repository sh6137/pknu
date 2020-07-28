<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="PKG_DB.DBCon" %>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="org.json.simple.*" %>
<%@ page language="java" import="org.json.simple.parser.JSONParser" %>



<%
	String strStu_ids = request.getParameter("jsonData");

	DBCon db = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "testdb", "1234");


	JSONParser jsonParser = new JSONParser();
	
	JSONArray arr = (JSONArray)jsonParser.parse(strStu_ids);
	
	int arrSize = arr.size();
	String[] arrSTU_ID = new String[arrSize];
	   
	String[] strParams = new String[1];
	String strProcName = "CALL PKG_STUDENTS.PROC_DEL_STUDENTS(?)";
	
	for(int i=0; i<arr.size(); i++){
        
	      JSONObject obj = (JSONObject)arr.get(i);
	      
	      arrSTU_ID[i] = (String)obj.get("stu_id");
	      
	      strParams[0] = arrSTU_ID[i];
	      db.setUpdate(strProcName, strParams);
	      
	   }
	
//	db.setUpdate(strProcName, strParams);
	
	
	
%>