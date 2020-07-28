<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../FileUpload" method="post" name="frm" enctype="multipart/form-data">
		<div><input type="text" name="content" id="content"/></div>
		<div><input type="file" name="filename" id="filename" /></div>
		<div><input type="submit" value="확인" />
	</form>
</body>
</html>