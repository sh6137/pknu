<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
   div {
      border : 1px solid blue;
      width  : 300px;
      float  : left;
      border-radius : 10px;
   }
</style>
<body>
	<h1>list 회원목록</h1>
	<a href = "/WriteForm">글쓰기</a>
	<br>
	<c:forEach var="user" items="${userList}">
	<div>
	<ul>
		<li>이름 : ${user.name}</li>
		<li>전번 :<a href="/View?tel=${user.tel}">${user.tel}</a></li>
	</ul>
	</div>
	</c:forEach>
	<p>
	

</body>
</html>