<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var person = {
		name : '이민성',
		eat : function (food) {
			alert(this.name + '이' + food + '을 먹습니다.');
		}
}
person.eat('빵');

</script>
<script type="text/javascript">
	var product = {
		name : 'Microsoft Visual Studio 2015 Ultimate',
		price : '15,000,000원',
		langauge : '한국어',
		supportOS : 'Win 32/64',
		subscription : true
	};
	window.onload = function() {
	var msg = '';
	msg += '<h1>' + person.name + '</h1>';
	for(var key in product){
		msg += '' + key + ' : ' + product[key] + '<br>';
	}
	document.body.innerHTML = msg;	
		
	}
</script>
</head>
<body>

</body>
</html>