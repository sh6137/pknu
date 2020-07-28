<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page language="java" import = "java.sql.*" %>
<%@ page language="java" import = "org.json.simple.JSONArray" %>
<%@ page language="java" import = "org.json.simple.JSONObject" %>

<%
	String strUserID = request.getParameter("userID");
	
	//1.DB연결
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbUid = "testdb";
	String dbPwd = "1234";

	Class.forName("oracle.jdbc.driver.OracleDriver");
	//1. CONNECTION
	Connection conn = DriverManager.getConnection(url, dbUid, dbPwd); 
	
	
	String strProc = "call PKG_MEMBERS.PROC_IDCHECK(?,?)";
	CallableStatement cstmt = conn.prepareCall(strProc);
	cstmt.setString(1, strUserID);
	cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
	
	cstmt.execute();
	ResultSet rs = (ResultSet)cstmt.getObject(2);
	
	//rs 에 있는 데이터를 json 으로 바꿔서 웹페이지로 돌려줘야 한다.
	JSONArray arr  = new JSONArray();
	while(rs.next()){
		JSONObject obj = new JSONObject();
		obj.put("CNT", rs.getString("CNT"));
		
		arr.add(obj);
	}
	response.setContentType("Application/json");
	
	out.println(arr);

%>