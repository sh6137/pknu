<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function(){
	
	console.log(window);
	var msg = '';
	for (var key in window) {
		msg+= key + ':' + window[key] + '\n';
	}
	window.alert(msg);
	document.body.innerHTML = msg.replace(/\n/gim,'<br>');
}
</script>
</head>
<body>
	<h1><%out.print("dd"); %></h1>
</body>
</html>