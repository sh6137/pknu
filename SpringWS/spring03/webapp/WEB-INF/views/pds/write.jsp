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
  <h1>자료실 새글쓰기</h1>
  
  <%@include file="/WEB-INF/include/menus.jsp" %>
   <h2>dfldjflksfjd  ${pdsVo.menu_id } </h2>
  <form action="/PDS/Write" method="POST" enctype="multipart/form-data">
  <table>
  	<tr>
  		<td>작성자</td>
  		<td><input type="text" name = "writer"></td>
  	</tr>
  	<tr>
  		<td>제목</td>
  		<td><input type="text" name = "title"></td>
  	</tr>
  	<tr>
  		<td>내용</td>
  		<td><textarea name="cont" rows="5" cols = "60"></textarea></td>
  	</tr>
  	<tr>
  		<td>파일입력</td>
  		<td><input type="file" name="upfile"></td>
  	</tr>
  	<tr>
  		<td>
  			<input type="submit" value ="저장">
  		</td>
  		
  	</tr>
  	
  	<!-- menu_id, bnum, lvl, step, nref -->
  	<input type="hidden" name="menu_id"	value="${ pdsVo.menu_id }">
  	<input type="hidden" name="bnum"	value="${ pdsVo.bnum }">
  	<input type="hidden" name="lvl"		value="${ pdsVo.lvl }">
  	<input type="hidden" name="step"	value="${ pdsVo.step }">
  	<input type="hidden" name="nref"	value="${ pdsVo.nref }">
  </table>
  </form>
</body>
</html>