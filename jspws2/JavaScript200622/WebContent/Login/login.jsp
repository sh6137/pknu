<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>

</style>

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

	<%
		
		String reqMsg = request.getParameter("msg");
	%>

<script>

if("<%=reqMsg%>" == "fail"){
	alert("아이디 또는 패스워드가 틀려요!!!!");
}

</script>

<script>
	$(document).ready(
			
		function(){
						
			//1.btnLogin 클릭이벤트
			$("#btnLogin").click(
					
				function(){
					loginOK();
				}
			
			); //click
			
			//2.btnCheck 클릭이벤트
			$("#btnCheck").click(
					
				function(){
					$.ajax(
							{
							
								url:"./logincheck.jsp",
								type : "get",
								datatype : "json",
								data:"userID=" + $("#userID").val(),
								success:function(datas){
									var result = datas[0].CNT
									if(result == "1"){
										//중복되었다
										$("#chkMsg").html("중복되어 사용하실수 없습니다.");
									}
									else{
										//사용해도 된다.
										$("#chkMsg").html("사용가능한 아이디입니다.");
									}
									
								}
								,
								error : function(err){
									alert("에러");
								}
								
							}
						
					); //ajax
				}
			
			); //btnClick
			
				
		} //
		
	); //document.ready

	
	
	
	var loginOK = function(){
		//1.아이디가 입력되었는지 확인
		var idVal = $("#userID").val();
		
		if(idVal.length < 4){
			alert("아이디를 정확하게 입력하세요");
			return;
		}
		
		//2. 패스워드 입력 체크
		var pwdVal = $("#userPass").val();
		if(pwdVal.length < 4){
			alert("패스워드를 정확하게 입력하세요");
			return;
		}
		
		loginForm.submit();
	
	}
	
</script>
</head>
<body>
	<form name="loginForm" method="post" action="login_ok.jsp">

		<div id="wrap">
			<ul>
				<li>
					<div>아이디</div>
					<div>
						<input type="text"  id="userID" name="userID" />
						<input type="button" id="btnCheck" value="아이디중복체크" />
						<span id="chkMsg"></span>
					</div>
				</li>
				<li>
					<div>패스워드</div>
					<div><input type="text" id="userPass" name="userPass" /></div>
				</li>
				<li>
					<input type="button" value="로그인" id="btnLogin" />
				</li>
			</ul>
		</div>


	 </form>

</body>
</html>