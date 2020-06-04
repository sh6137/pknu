<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

  window.onload = function() {
   var today      =  new Date();
   var  msg       =  '클라이언트 시간:' +  today.toLocaleString();   
   // alert( msg );
   var  div1      =  document.getElementById('div1');
   div1.innerHTML =  msg ;
  }  
</script>
</head>
<body>
  <h1>Hello</h1>
  <h2>
  <% 
      java.util.Date  today = new java.util.Date();      
  	  out.print("서버시간:");    
      out.print(  today.toLocaleString() );  // 서버의 컴퓨터시간
      System.out.print(today.toLocaleString() );
  %>  
  </h2>
  <div id="div1"></div>
  <div id="div2"></div>
  <script>
     var  div2      = document.getElementById('div2');
     div2.innerHTML = '<h2>안녕하세욤!!!</h2>';
  </script>
  
</body>
</html>