<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" action="write_ok.jsp" method="post" enctype="multipart/form-data">
	<div>
		<div>작성자 : <input type="text" name="write" id="write" /></div>
		<div>글내용 : <input type="text" name="content" id="content" /></div>
		<div>파일선택 : <input type="file" name="fileName1" id="fileName1" /></div>
		<div>파일선택 : <input type="file" name="fileName2" id="fileName2" /></div>
		<div><input type="submit" name="submit" value="확인" /></div>
	</div>
	</form>
</body>
</html>