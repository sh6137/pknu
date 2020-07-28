<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.rec{ width:200px; height:200px; border:1px solid blue; background-color:red; }
	.drop{ width:500px; height:500px; border:1px solid blue; background-color:#dedede; }
	.at{background-color: pink;}
	.ht{background-color: black;}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(
		function () {
			$("#rect").draggable({
				helper : "original"
			});
			$("#ddd").droppable({
				
				activeClass : "at",
				hoverClass:"ht",
				activate : function (event, ui) {
					alert("activate");
				},
				create : function(event, ui){
					
				},
				deactivate : function(event,ui){
					
				},
				drop : function (event,ui) {
					 
				},
				out : function (event, ui) {
					
				},
				over: function(event,ui){
					
				}
				,
				
				
			});
		}		
	);
</script>
</head>
<body>
	<div class = "rec" id ="rect">
	</div>
	<div class ="drop" id ="">
	</div>
	<div class="drop" id ="ddd">
	
	</div>
	
</body>
</html>