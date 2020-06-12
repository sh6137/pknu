<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function winopen() {
	var html = 'http://www.naver.com';
	var name = '';
	var features = 'height = 200, width = 300';
	var child = window.open(html,name,features);
	if(child){
		var newhtml = '<h1>주소찾기</h1>';
		newhtml += '<input type = "text" name="dong"/>';
		child.document.write(newhtml);
		
	}else{
		alert('팝업차단을 해제해주세요');
	}
}
</script>
</head>
<body>
	<input type = "button" onclick = "winopen()" value = "주소찾기"><br>
	<input type = "button" onclick = "location.href = 'http://www.naver.com'" value = "네이버로 가기"><br>
	<input type = "button" onclick = "document.url = 'http://www.naver.com'" value = "네이버로 가기"><br>
	<input type = "button" onclick = "location.assign = 'http://www.naver.com'" value = "네이버로 가기"><br>
	<input type = "button" onclick = "history.back()" value = "뒤로 가기"><br>
	<input type = "button" onclick = "history.go(1)" value = "앞으로 가기"><br>
	
</body>
</html>