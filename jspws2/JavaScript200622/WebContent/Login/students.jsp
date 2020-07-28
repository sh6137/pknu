<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

<script type="text/javascript">
	var obj = {bid : "b01", bname: "dsdds"};
	// alert(obj.bid);
	/* var students =[
		
			{sid : "S001",sname : "홍길동"},
			{sid : "S002",sname : "김동수"},
			{sid : "S003",sname : "박길홍"},
			{sid : "S004",sname : "전우치"}
	]; */
	
	var students = [];
 
 var numbers = ["a","b","c"];
	//1.이벤트 등록
	$(document).ready(
		function() {
			
			$("#btnAjax").click(
				function() {
					$.ajax({
						url : "./students_json.jsp",
						type : "get",
						datatype : "json",
						success : function(datas){
							students = datas;
							alert("데이터 가져오기에 성공 조회클릭");
						},
						error : function(){
							alert("err");
						}
					});
			});
			
			$("#btnSearch").click(
				function() {
					var strHTML = "";
					$.each(
							students,
							function(students, item){
								//alert(item.sid);
								strHTML += "<div> "+item.sid+"  : 이름  :  "+item.sname +" </div>";
							}
					);
					$("#list").html(strHTML);
				}
			);
		}
	);
</script>
</head>
<body>
	<div id ="wrap">
		<div>
			<input type="button" id = "btnAjax" value = "데이터를 들고와라">
		</div>
		<div>
			<input type="button" id = "btnSearch" value = "조회">
		</div>
	<!-- 
		<div>
			번호  : S001 - 이름:홍길동
		</div>
	</div>
	 -->
		<div id = "list">
    	</div>
	</div> 
</body>
</html>