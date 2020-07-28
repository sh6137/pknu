<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="../css/scores.css">
<style>
	#dept{display:none}
	#student{display:none}
</style>

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="../js/scores.js"></script>

<script>

	$(document).ready(
	
			function(){
				
				getYear("year");
				
				getCollege("college");
				
				
				//이벤트 등록
				$("#college").change(
					function(){
						
						var selectedValue = $("#college").val();
						getDept(selectedValue, "dept");
						$("#dept").css("display", "inline");
						
					}		
				);
				
				$("#dept").change(
					function(){
						var selectedValue = $("#dept").val();
						getStudents(selectedValue, "student");
						$("#student").css("display", "inline");
					}		
				);
				
				$("#student").change(
					function(){
						
						var stu_id = $("#student").val();
						var syear = $("#year").val();
						var ssemester = $("#semester").val();
						
						getSubjects(stu_id, syear, ssemester, "subject");
						
					}		
				);
				
				$("#btnSave").click(
					function(){
						frm.submit();
					}		
				);
				
				
			}//ready func
			
	); //ready

</script>


</head>
<body>
	<form action="./register_ok.jsp" method="post" id="frm" name="frm">
	<table border="1" width="90%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td width="30%">
				학생이름
			</td>
			<td width="70%">
				<select id="college" name="college">
				
				</select>
				<select id="dept" name="dept">
				
				</select>
				<select id="student" name="student">
				
				</select>
			</td>
		</tr>
		<tr>
			<td width="30%">
				시험학기
			</td>
			<td width="70%">
				<select id="year" name="year">
					
				</select>
				년
				<select id="semester" name="semester" class="easyui-combobox">
					<option value="1">1</option>
					<option value="2">2</option>
				</select>
				학기
				&nbsp;&nbsp;&nbsp;
				<select id="gubun" name="gubun">
					<option value="1">중간고사</option>
					<option value="2">기말고사</option>
				</select>
			</td>
		</tr>
		<tr>
			<td width="30%">
				시험과목
			</td>
			<td width="70%">
				<select id="subject" name="subject">
				
				</select>
			</td>
		</tr>
		<tr>
			<td width="30%">
				시험점수
			</td>
			<td width="70%">
				<input type="text" id="score" name="score" />
			</td>
		</tr>
		<tr>
			<td width="30%">
				시험날짜
			</td>
			<td width="70%">
				<input type="text" id="examdate" name="examdate" />
			</td>
		</tr>
		<tr>
			<td width="100%" colspan="2" align="center">
				<input type="button" id="btnSave" name="btnSave" value="확인" />
			</td>
		</tr>
	</table>
	</form>
</body>
</html>