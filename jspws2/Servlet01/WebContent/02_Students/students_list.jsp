<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="java.util.ArrayList" %>
<%@ page language="java" import="PKG_STUDENT.*" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.col1{width:250px;height:30px;float:left;}
	#rows{clear:both;}
</style>

</head>

<%
	//ArrayList arr = (ArrayList)request.getAttribute("students")
	ArrayList<Student> arr = (ArrayList<Student>)request.getAttribute("students");
%>

<body>
	<div>리스트</div>
	<%
		//for(int i=0;i<arr.size();i++)
			
			//for (Object obj : arr){
				
			//String strStu_ID = ((Student)obj).getStu_id();
			//String strStu_Name = ((Student)obj).getStu_name();
			//String strStu_Tel = ((Student)obj).getStu_tel();
	%>
<%-- 	
			<div>학생 아이디 : <%=strStu_ID %></div>
			<div>학생 이름 : <%=strStu_Name %> </div>
			<div>학생 연락처 : <%=strStu_Tel %></div>  --%>
	<%
	
			//}
	%>
	
	<%
		for (Student stud : arr){
			
			String strStu_ID = stud.getStu_id();
			String strStu_Name = stud.getStu_name();
			String strStu_Tel = stud.getStu_tel();
	%>
	<div id="rows">
			<div class="col1">학생 아이디 : <a href="./Students?stu_id=<%=strStu_ID%>&doWork=detail"><%=strStu_ID %></a></div>
			<div class="col1">학생 이름 : <%=strStu_Name %> </div>
			<div class="col1">학생 연락처 : <%=strStu_Tel %></div> 
	</div>
	<%
	
			}
	%>
	
	
	<div><a href=""></a></div>
	
</body>
</html>