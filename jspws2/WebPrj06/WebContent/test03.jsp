<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>페이지이동</h1>
<pre>


</pre>

<h2>1.a tag 를 사용한 페이지 이동</h2>
<a href = "http://127.0.0.1:9090/WebPrj06/test03_proc.jsp?name=aaa&tel=010-1234-5478">서버로 이동</a>
<h2>2.form 를 사용한 페이지 이동</h2>

<form action="http://127.0.0.1:9090/WebPrj06/test03_proc.jsp" method = "GET">
	<input type = "text" name = "name" value = "이름">
	<input type = "text" name = "tel" value = "번호">
	<input type = "submit"value="서버로 이동">
</form>
<form action="http://127.0.0.1:9090/WebPrj06/test03_proc.jsp" method = "POST">
	<input type = "text" name = "name" value = "이름">
	<input type = "text" name = "tel" value = "번호">
	<input type = "submit"value="서버로 이동">
</form>

<form action="http://127.0.0.1:9090/WebPrj06/test03_proc.jsp?name=aaa&tel=010-1234-5478" method = "GET">
	<input type = "text" name = "name" value = "이름">
	<input type = "text" name = "tel" value = "번호">
	<input type = "submit"value="서버로 이동">
</form>
<br><br>
<h2>3.javascript get 전송</h2>
<input type = "button" onclick="send()">
<script type="text/javascript">
	function send(){
		location.href="http://127.0.0.1:9090/WebPrj06/test03_proc.jsp?name=aaa&tel=010-1234-5478";
	}
</script>
<h2>4. javascript get/post</h2>
<form method = "post">
	<input type = "text" name = "name" value = "이름">
	<input type = "text" name = "tel" value = "번호">
	<input type = "text" name = "email" value = "이메일">
	<input type = "button" value = "Click2" onclick='send2()'>
</form>
<script type="text/javascript">
	function send2(){
		//document.forms[0].submit();
		var myform = document.querySelectorAll('form')[3]
		myform.action = 'http://127.0.0.1:9090/WebPrj06/test03_proc.jsp';
		myform.submit();
	}
</script>


</body>
</html>