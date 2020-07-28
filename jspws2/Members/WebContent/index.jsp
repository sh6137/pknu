<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	 boolean isSuc = (boolean)request.getAttribute("isSuc");

	String msg = "";
	
	if(isSuc){
		msg = "로그인 성공";
	}
	else{
		msg = "여기는 우리홈페이지 메인입니다. [로그인전입니다.]";
	}
%>

<body>

	<!-- 학생리스트 -->

	
	<div id="msg"><%=msg %></div>
	<p/>
	<% if(isSuc) { %>
	<a href="./Test.do">테스트</a>
	<a href="./Login?gubun=logout">로그아웃</a>
	<% } 
	 else { %>
	<a href="./JW.Fire?gubun=login">로그인</a>
	<% } %>
</body>
</html>