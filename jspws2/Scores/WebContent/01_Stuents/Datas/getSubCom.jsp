<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page language="java" import="PKG_DB.DBCon" %>    
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="org.json.simple.JSONArray"%>
<%@ page language="java" import="org.json.simple.JSONObject"%>   

<%
   
   DBCon db = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "testdb", "1234");
   
   String strProcName = "CALL PKG_STUDENTS.PROC_COM_STUDENTS(?)";
   
   String[] strParams = { "" };
   String[] strInOut = {"OUT"};
   int[] sqlTypes = {oracle.jdbc.OracleTypes.CURSOR};   // strInOut때문에 준다
   
   ResultSet rs = db.getResultSet(strProcName, strParams, strInOut, sqlTypes);
   
   JSONArray arr = new JSONArray();
   while(rs.next()) {
      
      JSONObject obj = new JSONObject();
      obj.put("stu_id", rs.getString("STU_ID"));
      obj.put("stu_name", rs.getString("STU_NAME"));
      
      arr.add(obj);
   }
   
   response.setContentType("Application/json");
   out.println(arr);
   
%> 