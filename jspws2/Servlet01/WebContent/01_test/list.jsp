<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String strID = (String)request.getAttribute("id");

%>
<body>
리리리<br>
<a href="./hello.jsp">글쓰기</a>
<p>
<%=strID%>
</body>
</html>