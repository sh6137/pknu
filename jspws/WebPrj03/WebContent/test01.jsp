<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkAll(sw){
		var fruitsId = ['apple','mango','banana','orange','watermelon'];
		for (var i = 0; i <  fruitsId.length; i++) {
			
		var chkBox = document.getElementById( fruitsId[i]);
		console.dir(chkBox);
		chkBox.checked = sw;
		}
		
	}

	function divDisplay(msg){
		var div1 = document.getElementById('div1');
		div1.innerHTML = msg;
	}
	
	window.onload = function(){
		var person =['이순신','김유신','아이유']

		
		var msg = '';
		msg += person + '<br>';
		for (var i = 0; i < person.length; i++) {
			msg += person[i] + '<br>';
		}
		
		var students = {
				num : 1,
				name : '이순신',
				tel : '010-1111-1234'
				
		};
		msg +='<hr>';
		msg +='번호' + students.num + '<br>';
		msg +='이름' + students.name + '<br>';
		msg +='전화' + students.tel + '<br>';
		
		var fruits= ['사과','망고','바나나','오렌지','수박'];
		var fruitsId = ['apple','mango','banana','orange','watermelon'];
		msg +='<ul>';
		for(var i =0; i < fruits.length;i++){
			
		msg +='<li>' + fruits[i] + '</li>';
		}
		
		msg +='</ul>';
		msg +='<select>';
		for (var i = 0; i < fruits.length; i++) {
			msg +='<option>' + fruits[i]  + '</option>';
		}
		msg +='</select>';
		
		for (var i = 0; i < fruits.length; i++) {
			msg +='<input type = "checkbox" id =' + fruitsId[i] + '>';
			msg +='<label for = "'+ fruitsId[i]+'">' + fruits[i] + '</label>';
		}
		
		msg+='<hr>';
		msg+='<ul>';
		fruits.forEach(myFunc);
		fruits.forEach(function(value){
			msg += '<li>' + value + '</li>';
		});
		msg+='</ul>';
		
		var prod = ['사과', '바나나', '딸기'];
		msg += prod + '<br>';
		prod.push('오렌지');
		msg += prod + '<br>';
		
		var f = prod.pop();
		msg += f +'<br>';
		msg += prod +'<br>';
		msg += prod.lengh +'<br>';
		
		prod[999] = '두리안';
		msg += prod.lengh +'<br>';
		divDisplay(msg);
		
		var nums = [10,8,23,5,4,238];
		
		
		
		function myFunc(value) {
			msg += '<li>' + value + '</li>'
			
			
		
		}
	}
</script>
</head>
<body>
	<h1>Hello</h1>
	<p><%=  new java.util.Date() %>
	</p>
	<div id = "div1"></div>
	<button onclick="checkAll(true)">체크</button>
	<button onclick="checkAll(false)">체크해제</button>
</body>
</html>