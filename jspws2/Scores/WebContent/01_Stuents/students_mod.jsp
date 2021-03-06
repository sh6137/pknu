<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="../js/students.js"></script>


<script type="text/javascript">
	$(document).ready(
			function () {
				//1.선택된 학생의 정보를 가져와야 한다.
			var rowData = getSelStudent('<%=request.getParameter("chkVal")%>');
			$("#stu_name").val(rowData.stu_name);
			$("#stu_tel").val(rowData.stu_tel);
			
			var addr1 = "";
			var addr2 = "";
			var addr3 = "";
			var addr4 = "";
			
			if(rowData.addr4 =="-"){
				addr1 = rowData.addr3;
				addr2 = rowData.addr2;
				addr3 = rowData.addr1;
				addr4 = "";
				
			}
			else
			{
				addr1 = rowData.addr4;
				addr2 = rowData.addr3;
				addr3 = rowData.addr2;
				addr4 = rowData.addr1;
			}
			alert(rowData.addr4);
			
			getAddr2("",1,"sido",addr1);
			getAddr2(addr1,2,"gugun",addr2);
			getAddr2(addr2,2,"dong",addr3);
			getAddr2(addr3,2,"dong2",addr4);
			
			}	
	);
	
	
</script>

</head>


<body>
<div id = "wrap">
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
					<input type="text" id="stu_tel" name="stu_tel" />
				</div>
			</div>
			<div>
				<input type="submit" value="확인"  id="btnSubmit" />
			</div>
		</form>
	</div>
</body>
</html>