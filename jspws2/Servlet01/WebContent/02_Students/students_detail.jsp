<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="PKG_STUDENT.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

	function goList(){
		location.href="./Students?doWork=list";
	}

</script>
</head>

<%
	Student stud = (Student)request.getAttribute("student");

	String strID = stud.getStu_id();
	String strName = stud.getStu_name();
	String strTel = stud.getStu_tel();
%>

<body>
	<div>
	
		<div>학생아이디 : <%=strID %></div>
		<div>학생아이디 : <%=strName %></div>
		<div>학생아이디 : <%=strTel %></div>
		
	</div>
	<div>
	
		<input type="button" value="리스트로" onclick="goList()"/>
	
	</div>
</body>
</html>