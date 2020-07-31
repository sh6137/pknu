<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/common.css">
</head>
<body>
  <h1>${ menu_id } 자료실 목록보기</h1>
 
  
  <%@include file="/WEB-INF/include/menus.jsp" %>
    
  <table>
    <tr>
      <td>글번호</td>
      <td>제목</td>
      <td>작성자</td>
      <td>조회수</td>
      <td>파일첨부</td>
      <td>작성일</td>
    </tr>
    
    <c:forEach var="pdsVo" items="${ pdsList }" >
     <tr>
      <td>${ pdsVo.idx }</td>
      <td>
	      <a href="/PDS/View?idx=${ pdsVo.idx }&bnum=${pdsVo.bnum}&lvl=${pdsVo.lvl}&step=${pdsVo.step}&nref=${pdsVo.nref}&menu_id=${pdsVo.menu_id}">
	      		${ pdsVo.title }
	      </a>
      </td>
      <td>${ pdsVo.writer }</td>
      <td>${ pdsVo.readcount }</td>
      <td><a href="<c:out value='/download/external/${pdsVo.filename}'/>">${ pdsVo.filename }</a></td>
      <td>${ pdsVo.regdate }</td>
     </tr> 
    </c:forEach>
    <tr>
      <td colspan="6">
        <a href="/PDS/WriteForm?bnum=0&menu_id=${menu_id}&nref=0&step=0&lvl=0">새글쓰기</a>
      </td>
    </tr>
     
  </table>
</body>
</html>