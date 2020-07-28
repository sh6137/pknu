<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

<script>

	$(document).ready(
		function(){
			//1. 이벤트
			$("#btnLogin").click(
				function(){
					//유효성감사
					
					loginFrm.submit();
				}		
			);
			
			
		}		
	);

</script>

<%
	boolean isSuc = (boolean)request.getAttribute("isSuc");
	String strMsg = "";

	if(isSuc){
		strMsg = "";
	}
	else{
		strMsg = "로그인 실패";
	}
	
%>

</head>
<body>
<form action="./Login" method="post" name="loginFrm">
	<table width="400" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td width="100" align="center">
			아이디
			</td>
			<td width="300">
			<input type="text" name="userID" id="userID" />
			</td>
		</tr>
		<tr>
			<td width="100" align="center">
			패스워드
			</td>
			<td width="300">
			<input type="text" name="userPass" id="userPass" />
			</td>
		</tr>
		<tr>
			<td width="400" align="center" colspan="2">
			<input type="hidden" name="gubun" value="login" />
			<input type="button" name="btnLogin" id="btnLogin" value="로그인"/>
			<input type="button" name="" value="아이디/패스찾기"/>
			</td>
		</tr>
	</table>
	<div> <%=strMsg %> </div>
</form>	
</body>
</html>