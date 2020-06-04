<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
  var sumAll = function ( ) {
	  alert(typeof(arguments) + ':' + arguments.length)
  } 
  sumAll(1,2,3,4,5, 6, 7, 8, 9)
</script>
<script>
  var sumAll = function () {
	  var output = 0;
	  for (var i = 0; i < arguments.length; i++) {
		 output += arguments[i];
	  }
	  return output;
  }
</script>
<script>
  alert( sumAll(1,2,3,4,5) );
</script>
<script>
   function callTenTimes(callback) {
	   for (var i = 0; i < 10; i++) {
		  callback();
	   }
   }
   
   var callback = function () {
       alert('함수 호출');
   }
   callTenTimes(callback);


</script>
</head>
<body>

</body>
</html>