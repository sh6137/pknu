<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생등록폼</title>

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="../js/students.js"></script>

<script>

	$(document).ready(
		function(){
			
			/* 학생 주소 처리 시작 */
			getAddr("", 1, "sido");
			
			$("#sido").change(
				function(){
					$("#gugun").html("");
					$("#dong").html("");
					$("#dong2").html("");
					getAddr($("#addr1").val(), 2, "gugun");
				}		
			);
			
			$("#gugun").change(
					function(){
						$("#dong").html("");
						$("#dong2").html("");
						getAddr($("#addr2").val(), 3, "dong");
					}		
			);
			
			$("#dong").change(
					function(){
						$("#dong2").html("");
						getAddr($("#addr3").val(), 4, "dong2");
					}		
			);
			
			/* 학생 주소 처리 끝 */
			
			
			/* 학생 학과 처리 시작 */
			getDept("", 1, "college");
			
			$("#college").change(
					function(){
						$("#dept").html("");
						getDept($("#dept1").val(), 2, "dept");
					}		
			);
			/* 학생 학과 처리 끝 */
			
			
		} //function()
	); //ready()

</script>

</head>
<body>
	<div id="wrap">
	
		<form action="register_ok.jsp" method="post">
			<div>
				학생등록
			</div>
			<div>
				<div>학생이름</div>
				<div>
					<input type="text" id="stu_name" name="stu_name" />
				</div>
			</div>
			<div>
				<div>학생주소</div>
				<div>
					<span id="sido"></span>
					<span id="gugun"></span>
					<span id="dong"></span>
					<span id="dong2"></span>
				</div>
			</div>
			<div>
				<div>학생학과</div>
				<div>
					<span id="college"></span>
					<span id="dept"></span>
				</div>
			</div>
			<div>
				<div>학생연락처</div>
				<div>
					<input type="text" id="tel" name="tel" />
				</div>
			</div>
			<div>
				<input type="submit" value="확인"  id="btnSubmit" />
			</div>
		</form>
		
	</div>
</body>
</html>