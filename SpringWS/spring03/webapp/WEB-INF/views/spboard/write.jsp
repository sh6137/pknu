<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css">
</head>
<body>
  <form action="/SpBoard/Write" method="POST">
  <table>
  <caption>
  <h1>새글쓰기</h1>
  </caption>
  <tr>
     <td>제목</td>
     <td><input type="text" name="title" /></td>
  </tr>
  <tr>
     <td>이름</td>
     <td><input type="text" name="name" /></td>
  </tr>
  <tr>
     <td colspan="2"><input type="submit" value="저장" /></td>
  </tr>
  </table>
  </form>
</body>
</html>