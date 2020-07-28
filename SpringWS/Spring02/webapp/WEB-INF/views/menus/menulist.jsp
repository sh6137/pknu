<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>메뉴목록</h1>
   <table>
      <tr>
         <th>MENU_ID</th>
         <th>MENU_NAME</th>
         <th>MENU_SEQ</th>
      </tr>
   
   <c:forEach var="menuVo" items="${menuList }">
      <tr>
            <td>${menuVo.menu_id}</td>
            <td>${menuVo.menu_name}</td>
            <td>${menuVo.menu_seq}</td>
      </tr>
      
   </c:forEach>
   </table>
   
   <div>
      <a href="/Menus/WriteForm">메뉴추가</a>
   </div>
   
</body>
</html>