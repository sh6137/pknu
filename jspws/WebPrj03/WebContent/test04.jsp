<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		var div1 = document.getElementById('div1');
		var msg = '<ul>';
		msg += '<li>' + '오늘날짜 : ' +today + '</li>';
		msg += '<li>' + '오늘날짜 : ' +today.toLocaleDateString() + '</li>';
		msg += '<li>' + '년 : ' +today.getFullYear() + '</li>';
		msg += '<li>' + '월 : ' +(today.getMonth()+1) + '</li>';
		msg += '<li>' + '일 : ' +today.getDate() + '</li>';
		msg += '<li>' + '시 : ' +today.getHours() + '</li>';
		msg +=	'</ul>';
		div1.innerHTML = msg;
	}
</script>
</head>
<body>
	<div id="div1"></div>
</body>
</html>