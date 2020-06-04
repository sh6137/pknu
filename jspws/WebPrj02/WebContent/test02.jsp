<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   div { 
      font-size:20px;  
      font-weight: bold;      
   }
</style>
<script>
  function  sachic(v1, v2, op) {
	  var v = 0;
	  switch(op) {
	  case "계산(+)":   v  =  v1 + v2; break;
	  case "계산(-)":   v  =  v1 - v2; break;
	  case "계산(*)":   v  =  v1 * v2; break;
	  case "계산(/)":   v  =  v1 / v2; break;	  
	  }
	  return  v;
  }

  function calc( btn ) {
	  // 분모가 0 : divide by zero exception
      // 분모가 0.0 : Infinity, -Infinity
	  console.log( btn );
	  var val1 =  document.getElementById('val1');
	  var val2 =  document.getElementById('val2');
	  var x    =  parseInt(val1.value) ;  
	  var y    =  parseInt(val2.value) ;
	  if(y == 0) {
		  alert('분모가 0입니다');		
		  val2.select();
		  val2.focus();
		  return;
	  }
	  var op   =  btn.value; 
	  var z    =  sachic(x, y, op);
		  
	  var result = document.getElementById('result');
	  result.innerHTML = z;
  }
</script>

</head>
<body> 
  <h1>DOM : Document Object Method</h1>
  <h1>BOM : Browser  Object Method</h1>
  값1 <input type="text" id="val1" value="0"><br> 
  값2 <input type="text" id="val2" ><br>
  <input type="button"  value="계산(+)" onclick="calc(this)" />
  <input type="button"  value="계산(-)" onclick="calc(this)" /> 
  <input type="button"  value="계산(*)" onclick="calc(this)" /> 
  <input type="button"  value="계산(/)" onclick="calc(this)" />  
  결과 <div id="result"></div>
</body>
</html>