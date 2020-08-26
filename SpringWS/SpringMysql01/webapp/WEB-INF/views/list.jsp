 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
  <h1>목록</h1>
  <c:forEach  var="mVo" items="${ list }">
  <div>
     <ul>
        <li><a href="/Content?id=${mVo.id}">${mVo.userid}</a></li>
        <li>${mVo.username}</li>
        <li>${mVo.regdate}</li>
     </ul>
  </div>
  </c:forEach>

</body>
</html>