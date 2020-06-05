<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var today = new Date();
	var msg = '클라이언트 시간' + today.toLocaleDateString();
	alert(msg);
</script>
</head>
<body>
	<%
		java.util.Date today = new java.util.Date();
		out.print(today.toLocaleString());
		System.out.print(today.toLocaleString());
	%>
	<%
		
	%>
</body>
</html>