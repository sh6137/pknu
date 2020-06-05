<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//jsp  : wkqk 명령어 코딩
	String name = "이름";
	String msg = "jsp test";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
alert('1');
</script>


</head>
<body onload="alert('2')">

 <h1>hello jsp 한글 잘됨?</h1>
 <%out.print(name +"<br>"+ msg); %><br>
 <%= msg %>
<script>
	alert('3');
</script>
</body>
</html>