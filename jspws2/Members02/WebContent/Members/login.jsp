<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

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
			
			$("#btn").click(
				function(){
					
					var userID = $("#userID").val();
					var userPass = $("#userPass").val();
					
					$.ajax(
						{
							url : "./Login",
							type :"POST",
							datatype : "json",
							data : "userID=" + userID + "&userPass=" + userPass + "&gubun=ajax",
							success : function(data){
								if(data.result == "1"){
									$("#sendUserID").val(userID);
									loginForm.submit();
								}
								else
								{
									$("#showMsg").html("로그인 실패");
								}
							}
							,
							error : function(){
								
							}
						}		
					);
					
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
			<input type="button" name="btn" id="btn" value="ajax로그인"/>
			</td>
		</tr>
		<tr>
			<td width="400" align="center" colspan="2" id="showMsg"></td>
		</tr>
	</table>
	<div> <%=strMsg %> </div>
</form>	

<form name="loginForm" action="./Login">
	<input type="hidden" name="sendUserID" id="sendUserID" value=""/>
	<input type="hidden" name="gubun" value="LogSuc"/>
</form>


</body>
</html>