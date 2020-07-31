<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>메뉴추가</h1>
  <form action="/Menus/Write" method="POST">
     메뉴이름 <input type="text" name="menu_name" />
     <input type="submit" value="추가" />
  </form>
</body>
</html>