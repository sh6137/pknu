<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h2>메뉴 수정</h2>
   <form action="/Menus/Update" method="POST">
     <div>메뉴번호:<input type="text" name="menu_id" 
        value="${ menuVo.menu_id }" readonly /></div>
     <div>메뉴이름:<input type="text" name="menu_name" 
        value="${ menuVo.menu_name }"  /></div>
     <div>메뉴순서:<input type="text" name="menu_seq" 
        value="${ menuVo.menu_seq }"  /></div>
     <div><input type="submit" value="수정"  /></div>
   </form>
</body>
</html>