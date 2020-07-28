<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/Update" method="get">
<div>
	이름 : <input type="text" name = "name" value="${user.name}">
	전화 : <input type="text" name = "tel" value="${user.tel}">
</div>
<div>
	<input type="submit" value="고치기">
	
</div>
</form>

</body>
</html>