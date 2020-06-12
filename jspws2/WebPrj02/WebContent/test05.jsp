<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
   var array1 = new Array();                   // 0
   var array2 = new Array(10);                 // 10
   var array3 = new Array(273, 103, 57, 33);   // 4
   var array4 = [273, 103, 57, 33];            // 4
   alert(array1 + '\n' + array2 + '\n' + array3 + '\n' + array4 );
   alert(array1.length + '\n' + array2.length + '\n' + array3.length 
		   + '\n' + array4.length );
   alert(v2);    // undefined : 호이스팅
   var v2= 6;
</script>
</head>
<body>
   
</body>
</html>