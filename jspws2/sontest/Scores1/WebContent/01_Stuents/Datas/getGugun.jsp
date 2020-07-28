<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page language="java" import="PKG_DB.DBCon" %>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="org.json.simple.JSONArray" %>
<%@ page language="java" import="org.json.simple.JSONObject" %>

<%
	
	String strSido = request.getParameter("in_Sido");

	DBCon db = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "lje", "1");
	
	String strProcName = "call PKG_STUDENTS.PROC_SEL_GUGUN(?, ?)"; 
	
	Connection con = db.getConnection();
	
	CallableStatement cst = con.prepareCall(strProcName);
	
	cst.setString(1, strSido);
	cst.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
	
	cst.execute();
	
	ResultSet rs = (ResultSet)cst.getObject(2);

	
	JSONArray arr = new JSONArray();
	while(rs.next()){
		
		 JSONObject obj = new JSONObject();
		 obj.put("com_id", rs.getString("COM_ID"));
		 obj.put("grp_id", rs.getString("GRP_ID"));
		 obj.put("com_val", rs.getString("COM_VAL"));
		
		 arr.add(obj);
	}
	
	response.setContentType("application/json");
	out.println(arr);

%>