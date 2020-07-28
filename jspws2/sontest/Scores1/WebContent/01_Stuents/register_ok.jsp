<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="PKG_DB.DBCon" %>
<%@ page language="java" import="java.sql.*" %>

<%
	request.setCharacterEncoding("UTF-8");

	String strName = request.getParameter("stu_name");

	String straddr1 = request.getParameter("addr1");
	String straddr2 = request.getParameter("addr2");
	String straddr3 = request.getParameter("addr3");
	String straddr4 = request.getParameter("addr4");
	//out.println(straddr4);
	
	String strStuAddr = "";
	//String strStuAddr2 = "";
	
	if(straddr4.equals("-")){
		strStuAddr = straddr3;
	}
	else{
		strStuAddr = straddr4;
	}
	
	String strdept1 = request.getParameter("dept1");
	String strdept2 = request.getParameter("dept2");
	
	String strTel = request.getParameter("tel");
	
	
	String[] strParams = {strName, strTel, strStuAddr, "GRP001", straddr1, "GRP002", strdept2};
	
	DBCon db = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "lje", "1");
	String strProcName = "CALL PKG_STUDENTS.PROC_SAVE_STUDENT(?,?,?,?,?,?,?)";
	
	int updateCnt = db.setUpdate(strProcName, strParams);
	
	response.sendRedirect("./studentList.jsp");
	
%>