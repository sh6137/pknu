<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href = "css/div.css">
<script type="text/javascript">
//생성자 함수 : 중요
function makeStudent(name, kor, eng, mat){
	var obj ={
			//속성
			name : name,
			kor : kor,
			eng : eng,
			mat : mat,
			//메소드
			getSum : function(){
				return this.kor  + this.eng + this.mat;
			},
			getAvg : function (){
				return this.getSum()/3;
			},
			
			toString : function() {
	            var msg = '<ul>';
	            msg += '<li>' + this.name + '</li>';
	            msg += '<li>' + this.kor + '</li>';
	            msg += '<li>' + this.eng + '</li>';
	            msg += '<li>' + this.mat + '</li>';
	            msg += '<li>' + this.getSum() + '</li>';
	            msg += '<li>' + this.getAvg() + '</li>';
	            msg += '<ul>';
	            return msg;
	         }
	};
	return obj;
}
window.onload = function(){
	var msg ='';
	var students = [];
	students.push(makeStudent('태화1',100,100,100));
	students.push(makeStudent('태화2',90,100,100));
	students.push(makeStudent('태화3',95,100,90));
	students.push(makeStudent('태화4',80,100,0));
	
	for (var i in students) {
		msg += '<div>';
		msg += students[i].toString();
		msg += '</div>';
	}
	document.body.innerHTML += msg;
}

</script>
</head>
<body>
<h1>생성자함수</h1>
</body>
</html>