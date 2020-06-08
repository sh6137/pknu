<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <style>
	div{
		border : 1px solid blue;
		border-radius : 20px;
		padding : 10px;
		width : 400px;
		margin : 10px;
	}
</style> -->
<link rel="stylesheet" href = "css/div.css">
<script type="text/javascript">
	var studs = [];
	studs.push({이름 : '형호1', 국어 :100 , 영어:100 , 수학:100 });
	studs.push({이름 : '형호2', 국어 :90 , 영어:100 , 수학:100 });
	studs.push({이름 : '형호3', 국어 :80 , 영어:100 , 수학:100 });
	studs.push({이름 : '형호4', 국어 :70 , 영어:90 , 수학:100 });
	studs.push({이름 : '형호5', 국어 :75 , 영어:100 , 수학:100 });
	studs.push({이름 : '형호6', 국어 :85 , 영어:100 , 수학:80 });
	studs.push({이름 : '형호7', 국어 :60 , 영어:100 , 수학:100 });
	studs.push({이름 : '형호8', 국어 :0 , 영어:100 , 수학:100 });
	studs.push({이름 : '형호9', 국어 :60 , 영어:100 , 수학:0 });
	studs.push({이름 : '형호10', 국어 :90 , 영어:100 , 수학:100 });
	
	window.onload = function() {
		
		//총점, 평균을 구한다.
		//총점구하기함수, 평균구하기를 추가
		for(var i in studs){
			studs[i].getSum = function(){
				return this.국어 + this.영어 + this.수학;
			}
			studs[i].getAvg = function(){
				return this.getSum()/3;
			}
			studs[i].toString =function(){
				var msg = '';
				msg += '<ul>';
				msg += '<li>' + this.이름 + '</li>';
				msg += '<li>' +this.국어 + '</li>';
				msg += '<li>' +this.영어 + '</li>';
				msg += '<li>' +this.수학 + '</li>';
				msg += '<li>' +this.getSum() + '</li>';
				msg += '<li>' +this.getAvg().toFixed(2) + '</li>';
				msg += '</ul>';
				return msg;
			}
		}
		
		//출력한다.
		var msg = '';
		for(var i in studs){
			msg += '<div>';
			msg+=  studs[i].toString();
			msg += '</div>';
		}
		document.body.innerHTML = msg;
	
	};
</script>
</head>
<body>


</body>
</html>