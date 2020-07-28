<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ page language="java" import="java.sql.*"%>   
    
<%
		String strUserID = request.getParameter("userID");
		String strUserPass = request.getParameter("userPass");


	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "testdb";
	String pwd = "1234";

	Class.forName("oracle.jdbc.driver.OracleDriver");	
	
	
	Connection con = DriverManager.getConnection(url, user, pwd);
	
	String strProc = "call PKG_MEMBERS.PROC_LOGIN(?,?,?)";
	
	CallableStatement csmt = con.prepareCall(strProc);
	csmt.setString(1, strUserID);
	csmt.setString(2, strUserPass);
	csmt.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
	
	csmt.execute();
	
	ResultSet rs = (ResultSet)csmt.getObject(3);
	
	rs.next();
	
	String strCnt = rs.getString("CNT");
	
	if(strCnt == "1"){
		//mainpage로 이동
	}
	else //로그인 실패
	{
		response.sendRedirect("login.jsp?msg=" + "fail");
	}
		
%>