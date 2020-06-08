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
function makeStudent(name, kor, eng, mat ,rank){
	var obj ={
			//속성
			name : name,
			kor : kor,
			eng : eng,
			mat : mat,
			rank : rank,
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
	            msg += '<li>' + this.getGrade() + '</li>';
	            msg += '<li>' + this.rank + '</li>';
	            msg += '<ul>';
	            return msg;
	         },
			
			getGrade : function(){
				if(this.getAvg() == 100){
					return 'A+';
				}else if (this.getAvg() <100 && this.getAvg()>=90){
					return 'A';
				}else if (this.getAvg() <90 && this.getAvg()>=80){
					return 'B';
				}
				else if (this.getAvg() <80){
					return 'C';
				}
			},
			
	};
	return obj;
}
window.onload = function(){
	var msg ='';
	var students = [];
	students.push(makeStudent('태화1',100,100,100,0));
	students.push(makeStudent('태화2',90,100,100,0));
	students.push(makeStudent('태화3',80,100,50,0));
	students.push(makeStudent('태화4',80,100,80,0));
	
	
	
	
	for (var i in students) {
		var cnt =0;
		var j = 1;
		for (var j in students){
			if( students[i].getAvg() < students[j].getAvg()){
				cnt +=1;
				console.log();
				students[i].rank = cnt;
				console.log(students[i].rank);
				
			}
		}
		msg += '<div>';
		msg += students[i].toString();
		msg += '</div>';
		
		
	}
	
	students.forEach(function(value, index, array){
		var student =value;
		msg += '<div>';
		msg += student.toString();
		msg += '</div>';
	})
	document.body.innerHTML += msg;
}

</script>
</head>
<body>
<h1>생성자함수</h1>
</body>
</html>