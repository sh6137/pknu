<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	여기는 테스트페이지입니다.
	
	<%
		String str = (String)request.getAttribute("a");
	%>
	
	<%=str %>
</body>
</html>