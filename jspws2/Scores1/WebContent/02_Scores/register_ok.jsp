<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page language="java" import="PKG_DB.DBCon" %>
<%@ page language="java" import="java.sql.*" %>

    
    
<% 
	String strSub_ID = request.getParameter("subject");
	String strYear = request.getParameter("year");
	String strSemester = request.getParameter("semester");
	String strGubun = request.getParameter("gubun");
	String strStu_ID = request.getParameter("student");
	String strScore = request.getParameter("score");
	String strExamDate = request.getParameter("examdate");

	
		DBCon db = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "lje", "1");
	
		String strProcName = "CALL PKG_SCORES.PROC_INS_SCORES(?,?,?,?,?,?,?,?)";  
		
		String[] strParams = new String[8];
		strParams[0] = strSub_ID;
		strParams[1] = strYear;
		strParams[2] = strSemester;
		strParams[3] = strGubun;
		strParams[4] = strStu_ID;
		strParams[5] = strScore;
		strParams[6] = strExamDate;
		strParams[7] = "";
		String[] strInOut = {"IN", "IN", "IN","IN", "IN", "IN", "IN", "OUT"};
		int[] sqlTypes = {0, 0, 0, 0, 0, 0, 0, oracle.jdbc.OracleTypes.CURSOR};
		
		ResultSet rs = db.getResultSet(strProcName, strParams, strInOut, sqlTypes);	
		
		rs.next();
		
		String strResult = rs.getString("RST");
		
		if (strResult.equals("SUC")){
			response.sendRedirect("./score_list.jsp");
		}
		else{
			response.sendRedirect("./register.jsp");
		}
		
%>