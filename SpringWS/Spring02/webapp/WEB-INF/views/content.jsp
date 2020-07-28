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
	<h2>글내용보기</h2>
	<table>
		<caption>
			<a href="/Board/WriteForm">새글쓰기</a>
			<a href="/Board/List">목록으로</a>
			<a href="/Board/UpdateForm?idx=${boardVo.idx}">수정</a>
			<a href="/Board/Delete?idx=${boardVo.idx}">삭제</a>
		</caption>
		<tr>
			<th>번호</th>
			<td>${boardVo.idx}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boardVo.title}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${boardVo.name}</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${boardVo.regdate}</td>
		</tr>
	</table>
</body>
</html>