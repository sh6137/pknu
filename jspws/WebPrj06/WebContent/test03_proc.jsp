<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>넘어온정보</h1>
	<div> 이름 : <%=name %> </div><br>
	<div> 전화 : <%=tel %> </div><br>
	<div> 메일 : <%=email %> </div><br>
</body>
</html>