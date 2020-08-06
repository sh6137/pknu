<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css" />
</head>
<body>
  <table>
  <caption>
  	<h1>SpBoard 목록(List)</h1>
  	<a href="/SpBoard/WriteForm">새 글 쓰기</a>  
  </caption>
  <tr>
    <th>&nbsp;</th>
    <th>&nbsp;</th>    
    <th>번호</th>
    <th>제목</th>
    <th>이름</th>
    <th>날짜</th>
  </tr>
  <c:forEach var="spboard" items="${ spBoardList }">
     <tr>
       <td>
          <a href="/SpBoard/Delete?idx=${ spboard.idx }">
            <img src="/img/delete.png" alt="삭제" title="${ spboard.idx }번 삭제"/>
          </a>
       </td>
       <td>
          <a href="/SpBoard/UpdateForm?idx=${ spboard.idx }">
            <img src="/img/update.png" alt="수정" title="${ spboard.idx }번 수정"/>
          </a>
       </td>
       <td>${ spboard.idx }</td>
       <td>${ spboard.title }</td>
       <td>${ spboard.name }</td>
       <td>${ spboard.regdate }</td>       
     </tr> 
  </c:forEach>
  </table>
</body>
</html>