<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, td{border : 1px solid #333333;
		border-collapse: collapse;
	}
	table{
		width:300px;
		margin :0 auto;
	}
	td:nth-child(1) {width:100px;}
	td:nth-child(2) {width:200px;}
	td[colspan] {text-align:center;}
</style>
</head>
<body>
	<table>
	<tr>
		<td>이름</td> 
		<td>${user.name}</td>
		
	</tr>
	<tr>
		<td>전화</td> 
		<td>${user.tel}</td>
		
	</tr>
	<tr>
		<td colspan="2">
			<a href="/List">목록으로 돌아가기</a><br>
			<a href="/UpdateForm?tel=${user.tel}">수정</a>
			<a href="/Delete?tel=${user.tel}">삭제</a>
		</td>	
	</tr>
	</table>
	
</body>
</html>