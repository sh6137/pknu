<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, th, td{border : 1px solid black ; border-collapse: collapse;}
	table {width:500px; margin:0 auto;}
	td:nth-of-type(1) {width : 400px}
	td:nth-of-type(2) {width : 100px}
</style>
</head>
<body>
	<form action="/Board/Update" method="POST">
	
	<table>
	
		<caption>
			<h1>글 수정 하기</h1>
			<a href="/Board/List">목록으로</a>
			
		</caption>
		<tr>
			<th>번호</th>
			<td><input type="text" name="idx" value="${boardVo.idx}" readonly="readonly"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${boardVo.title}"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" value="${boardVo.name}"></td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${boardVo.regdate}</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="수정">
		</tr>
	</table>
	</form>
</body>
</html>