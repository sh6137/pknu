<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>넘어온값</h2>
	<p>a:${vo.a}</p>
	<p>b:${vo.b}</p>
	<br>
	<h2>넘어온값</h2>
	<p>a:${attrName.a}</p>
	<p>b:${attrName.b}</p>
	<br>
	<h2>넘어온값</h2>
	<p>a:${param.a} (request.getParameter("a"))</p>
	<p>b:${param.b} (request.getParameter("b"))</p>
	<br>
</body>
</html>