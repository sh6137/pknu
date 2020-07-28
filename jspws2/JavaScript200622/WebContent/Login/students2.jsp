<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>

	var members = [];
	
	var getList = function() {
		$.ajax({
			
			url : "./memberList.jsp",
			type : "get",
			datatype : "json",
			success : function(datas){
				members = datas;
				setList();
			}
			,
			error : function(){
				alert("error");
			}
			
		});
	}
	
	var setList = function () {
		var strHTML = "";
		$.each(
			members, function (index,item) {
				strHTML +="<div><input type = 'checkbox' name = 'chkDel' value = '++'>" + item.username + "(" + item.userid +")</div>";
			}		
		);
		$("#list").html(strHTML);
	}
	var saveData = function () {
		var userID = $("#userID").val();
		var userPass = $("#userPass").val();
		var userName = $("#userName").val();
		
		var sendData = "userID=" + userID + "&userPass=" + userPass + "&userName=" + userName;
	      $.ajax({
	          url : "./students_save.jsp",
	          type : "post",
	          datatype : "json",
	          data : sendData,
	          success: function(datas){
	             alert(datas[0].suc);
	             var result = datas[0].suc;
	                if(result == "1"){
	                    getList();
	                 }
	                 else {
	                    alert("ERROR2");
	                 }

	          },
	          error: function(){
	             alert("ERROR");
	          }
	       });
	    }
	var delData = function() {
		var checkedValues = [];
		var chkObjs = $("input[name = 'chkDel']");
		//alert(chkObjs.length);
		
		$(chkObjs).each(
				function(index,item) {
				//	alert(item.checked);
					if(item.checked){
						checkedValues.push(item.value);
					}
				}
		);
		
		
	}
	$(document).ready(
			function() {
				getList(); //ajax 호출로 데이터 가져와라
				//1.btnSave Click 이벤트
				
				$("#btnSave").click(
						function () {
							  saveData();
						}
						
				);
				//setList(); // 가져온 테이터로 리스트 하라
				
				
				
				$("#btnDel").click(
						function() {
							delData();
				})
			}		
	);
</script>
</head>
<body>
	<div id ="wrap">
		
		<div id="write">
			<div>
				회원 아이디 : <input type="text" id = "userID" size="10">
			</div>
			<div>
				패스워드 : <input type="text" id = "userPass" size="10">
			</div>
			<div>
				회원 이름 : <input type="text" id = "userName" size="10">
			</div>
			<div>
				<input type="button"value = "저장" id = "btnSave">
				<input type="button"value = "삭제" id = "btnDel">
			</div>
			
			<div id="list">
				
			</div>
		</div>
	</div>
</body>
</html>