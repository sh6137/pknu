<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css" />
</head>
<body>
  <h1>메뉴 목록</h1>
  <c:forEach  var="menuVo" items="${ menuList }">
     <div>
        <a href="/Menus/UpdateForm?menu_id=${menuVo.menu_id}">
          <img src="/img/update.png" alt="수정" />
        </a>
        <a href="/Menus/Delete?menu_id=${menuVo.menu_id}">
          <img src="/img/delete.png" alt="삭제" />
        </a>
        ${ menuVo.menu_id } - ${ menuVo.menu_name } - ${ menuVo.menu_seq }  
     </div>
  </c:forEach>
  <div>
     <a href="/Menus/WriteForm">메뉴추가</a>
  </div>
</body>
</html>