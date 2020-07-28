<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.rec{ width:150px; height:300px; border:3px dotted tomato; }
	.rec2{ width:150px; height:300px; border:3px solid tomato; }
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(
			function(){
				$(".rec").draggable({
					connectToSortable : "#b"
				});
					
				$("#b").sortable({
		               activate : function(event, ui){
		                  //alert();
		               }      
		               ,
		               beforeStop : function(event, ui) {
		                  alert("beforestop");
		               }
		               ,
		               change : function(event, ui) {
		                  alert("change");   
		               }
		               ,
		               deactivate : function(event, ui)  {
		                  alert("deactivate");
		               },
		               out : function(event, ui) {
		                  alert("out");
		               },
		               over :function(event, ui) {
		                  alert("over");
		               },
		               receive : function(event, ui) {
		                  //alert("receive");
		               },
		               remove :function(event, ui) {
		                  alert("remove");
		               },
		               sort : function(event, ui) {
		                  alert("sort");
		               },
		               start :  function(event, ui) {
			                  alert("start");
			                  
		               }
		               ,
		               stop :  function(event, ui) {
			                  alert("stop");
			                  
		               }
		               ,
		               update : function(event, ui) {
			                  alert("start");
			                  
		               }
				});
				
			});
</script>
</head>
<body>
	<div id ="a"style="width:150px ; height : 100px ; border : 1px solid blue;">
		<div class ="rec">1</div>
		<div class ="rec">2</div>
	</div>
	<div id ="b" style="width:150px ; height : 100px ; border : 1px solid yellow;">
		<div class ="rec2">3</div>
		<div class ="rec2">4</div>
	</div>
</body>
</html>