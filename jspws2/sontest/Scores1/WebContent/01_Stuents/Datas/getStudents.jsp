<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page language="java" import="PKG_DB.DBCon" %>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="org.json.simple.JSONArray" %>
<%@ page language="java" import="org.json.simple.JSONObject" %>    
    
<%

	String setSelSearch = request.getParameter("selSearch"); 
	String setTxtSearch = request.getParameter("txtSearch"); 


	DBCon db = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "lje", "1");
	
	String strProcName = "CALL PKG_STUDENTS.PROC_SEL_STUDENTS(?, ?, ?)";
	
	String[] strParams = {setSelSearch, setTxtSearch, ""};
	String[] strInOut = {"IN", "IN", "OUT"};
	int[] sqlTypes = {0, 0, oracle.jdbc.OracleTypes.CURSOR};
	
	ResultSet rs = db.getResultSet(strProcName, strParams, strInOut, sqlTypes);
	
	
	JSONArray arr = new JSONArray();
	
	while(rs.next()){
		
		JSONObject obj = new JSONObject();
		
		obj.put("stu_id", rs.getString("STU_ID"));
		obj.put("stu_name", rs.getString("STU_NAME"));
		obj.put("stu_tel", rs.getString("STU_TEL"));
		obj.put("stu_addr", rs.getString("STU_ADDR"));
		obj.put("stu_dept", rs.getString("STU_DEPT"));
		
		
		arr.add(obj);
	}
	
	response.setContentType("Application/json");
	out.println(arr);
	
	
	

	
	
	
	
	
	
	
	
	
%>