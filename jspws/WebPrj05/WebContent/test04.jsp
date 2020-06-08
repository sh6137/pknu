<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var student = {}; //빈 객체
	student.이름 ='형호';
	student.취미 ='악기다루기';
	student.특기 ='프로그래밍';
	student.장례희망 ='sw아키텍처';
	student.toString = function(){
		var msg = '';
		for (var key in student) {
			if(key != 'toString'){
				if(key!=toString){
					msg+= key + ':' + student[key] + '\n';
				}
			}
		}
		return msg;
	}
	console.log(student);
	alert(student.toString());
	delete(student.특기);
	alert(student.toString());
	
	
</script>
</head>
<body>

</body>
</html>