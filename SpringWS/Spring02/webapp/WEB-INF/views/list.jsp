<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css"/>
<style>
	td:nth-of-type(1){width:100px;}
	td:nth-of-type(2){width:200px;}
	td:nth-of-type(3){width:100px;}
	td:nth-of-type(4){width:100px;}
</style>
</head>
<body>
	<table>
	<caption>
	<h2>목록보기</h2>
	<a href="/Board/WriteForm">새글 쓰기</a>
	</caption>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>이름</th>
		<th>날짜</th>
	</tr>
	<c:forEach var="board" items="${boardList}">
	<tr>
		<td>${board.idx }</td>
		<td><a href="/Board/Content?idx=${board.idx}">${board.title }</a></td>
		<td>${board.name }</td>
		<td>${board.regdate }</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>