<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, td{border : 1px, solid black; border-collapse : collapse;}
	table { width:300px; margin : 0 auto;}
	td:nth-of-type(1){width:100px;}
	td:nth-of-type(2){width:100px;}
	td[colspan]{text-align:center}
</style>
</head>
<body>
	<h1>회원정보수정</h1>
	<form action="/Update" method="POST">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name= "name" value="${user.name }"></td>
		</tr>
		<tr>
			<td>전화</td>
			<td><input type="text" name="tel" value="${user.tel}" readonly="readonly"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type = "submit" value = "수정">
			</td>
		</tr>
	</table>
	</form>
	
	<!-- <a href="/List">목록으로 돌아가기</a><br> -->
</body>
</html>