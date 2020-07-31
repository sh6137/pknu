<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/common.css">
</head>
<h1> 내용보기</h1>
 <%@include file="/WEB-INF/include/menus.jsp" %>
 
<table>
	<tr>
		<th>작성자</th>
		<td>${pdsVo.writer}</td>
		<th>작성일</th>
		<td>${pdsVo.regdate}</td>
	</tr>
	<tr>
		<th>글번호</th>
		<td>${pdsVo.bnum}</td>
		<th>조회수</th>
		<td>${pdsVo.readcount}</td>
	</tr>
	<tr>
		<th>글제목</th>
		<td colspan="3">${pdsVo.title}</td>
	</tr>
	<tr>
		<td colspan="4">${pdsVo.title}</td>
	</tr>
	
	<tr>
		<td colspan="4">${pdsVo.cont}</td>
	</tr>
	<tr>
		<td colspan="4">
		<div>
		<a href="/download/external/${pdsVo.filename}">${pdsVo.filename}</a>
		</div>
		</td>
	</tr>
	
	<tr>
		<td colspan="4">
		
		<a href="/Pds/List?menu_id=${pdsVo.menu_id}">리스트로</a>
		<a href="/Pds/WriteForm?menu_id=${pdsVo.menu_id}&bnum=0&lvl=0&step=0&nref=0">새글쓰기</a>
		<a href="/PDS/WriteForm?menu_id=${pdsVo.menu_id}&bnum=${pdsVo.bnum }&lvl=${pdsVo.lvl }&step=${pdsVo.step} &nref=${pdsVo.nref} ">답글쓰기</a>
		<a href="/PDS/UpdateForm?menu_id=${pdsVo.menu_id}&bnum=${pdsVo.bnum }&lvl=${pdsVo.lvl }&step=${pdsVo.step} &nref=${pdsVo.nref}">수정</a>
	</td>
	</tr>
	
</table>
<body>

</body>
</html>