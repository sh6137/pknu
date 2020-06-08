<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var msg = '';
	var student = {
		이름 : '이영효',
		국어 : 92, 수학 : 90, 
		영어 : 96, 과학 : 90
	};
	// student 객체안에 '이름' 속성이 존재하는가 true/ false;
	function is_object_in() {
		
	msg += '이름 : ' + ('이름' in student) + '\n';
	msg += '성별 : ' + ('성별' in student) + '\n';
	alert(msg);
	}
	
	function func1() {
		var div1 = document.getElementById('div1');
		var msg = '';
		msg += '이름 : ' + student.이름 + '<br>';
		msg += '국어 : ' + student.국어 + '<br>';
		msg += '수학 : ' + student.수학 + '<br>';
		msg += '영어 : ' + student.영어 + '<br>';
		msg += '과학 : ' + student.과학 + '<br>';
		student.tot = student.국어 + student.영어 + student.수학 + student.과학;
		var avg = student.tot/4;
		msg += '총점 : ' + student.tot + '<br>';
		msg += '평균 : ' + avg + '<br>';
		div1.innerHTML = msg;
	}
	
	function func2() {
		var msg ='';
		with(student){
			msg += '이름 : ' + 이름 + '<br>';
			msg += '국어 : ' + 국어 + '<br>';
			msg += '수학 : ' + 수학 + '<br>';
			msg += '영어 : ' + 영어 + '<br>';
			msg += '과학 : ' + 과학 + '<br>';
			msg += '총점 : ' + tot + '<br>';
		}
		var div2 = document.getElementById('div2');
		div2.innerHTML = msg;
		
	}
	
	window.onload = function() {
		is_object_in();
		func1();
		func2();
	}
</script>
</head>
<body>
	<div id='div1'></div>
	<div id='div2'></div>
</body>
</html>