<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Board/Write" method="POST">
	<table>
	<caption>
	<h1>새글 쓰기</h1>
	<a href="javascript:history.back()">뒤로</a>
	<a href="/Board/List">목록</a>
	</caption>
	<tr>
		<td>제목</td>
		<td><input type="text" name ="title"></td>		
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name ="name"></td>
	</tr>
	<tr>
	<td>
		<input type="submit" value="저장">	
	</td>
	</tr>
	</table>
	</form>
</body>
</html>