<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   div{ font-size : 20px; }
</style>
<script>

   function sachic(x, y, op){
      var v = 0; 
      
      switch(op){
      case '계산(+)': var v = x + y; break;
      case '계산(-)': var v = x - y; break;
      case '계산(*)': var v = x * y; break;
      case '계산(/)': 
         if(y == 0){
            alert('분모가 0입니다');
         }else
            var v = x / y; break;
      }
      
      return v;
   }
   
   function calc(btn){
      var val1 = document.getElementById('val1');
      var val2 = document.getElementById('val2');
      var x = parseInt(val1.value);
      var y = parseInt(val2.value);
      
      var op = btn.value;
      var z = sachic(x, y, op);
      
      var result = document.getElementById('result');
      result.innerHTML = z;
   }
   

</script>
</head>

<body>
   값1<input type = "text" id = "val1" value = "0"><br>
   값2<input type = "text" id = "val2" value = "0"><br>
   <input type = "button" value = "계산(+)" onclick = "calc(this)" />
   <input type = "button" value = "계산(-)" onclick = "calc(this)" />
   <input type = "button" value = "계산(*)" onclick = "calc(this)" />
   <input type = "button" value = "계산(/)" onclick = "calc(this)" /><br>
   
   결과 <div id = "result"></div>

</body>
</html>