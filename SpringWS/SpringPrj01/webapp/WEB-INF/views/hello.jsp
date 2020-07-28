<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%
	/* ctrl + shift + m */
	Date today = new Date();
	String todayStr = today.toLocaleString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>오늘 날짜</h1>
	<p><%=todayStr %></p>
</body>
</html>