<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		var div1 = document.getElementById('div1');
		var msg = '';
		
		var nums = [45,4,7,120,30];
		for (var i = 0; i < nums.length; i++) {
			msg += nums[i] + '&nbsp;&nbsp;';
		}
			
		div1.innerHTML = msg;
	}

</script>
</head>
<body>

	<div id="div1"></div>
</body>
</html>