<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�α���</title>
<style>

</style>

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

	<%
		
		String reqMsg = request.getParameter("msg");
	%>

<script>

if("<%=reqMsg%>" == "fail"){
	alert("���̵� �Ǵ� �н����尡 Ʋ����!!!!");
}

</script>

<script>
	$(document).ready(
			
		function(){
						
			//1.btnLogin Ŭ���̺�Ʈ
			$("#btnLogin").click(
					
				function(){
					loginOK();
				}
			
			); //click
			
			//2.btnCheck Ŭ���̺�Ʈ
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
										//�ߺ��Ǿ���
										$("#chkMsg").html("�ߺ��Ǿ� ����ϽǼ� �����ϴ�.");
									}
									else{
										//����ص� �ȴ�.
										$("#chkMsg").html("��밡���� ���̵��Դϴ�.");
									}
									
								}
								,
								error : function(err){
									alert("����");
								}
								
							}
						
					); //ajax
				}
			
			); //btnClick
			
				
		} //
		
	); //document.ready

	
	
	
	var loginOK = function(){
		//1.���̵� �ԷµǾ����� Ȯ��
		var idVal = $("#userID").val();
		
		if(idVal.length < 4){
			alert("���̵� ��Ȯ�ϰ� �Է��ϼ���");
			return;
		}
		
		//2. �н����� �Է� üũ
		var pwdVal = $("#userPass").val();
		if(pwdVal.length < 4){
			alert("�н����带 ��Ȯ�ϰ� �Է��ϼ���");
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
					<div>���̵�</div>
					<div>
						<input type="text"  id="userID" name="userID" />
						<input type="button" id="btnCheck" value="���̵��ߺ�üũ" />
						<span id="chkMsg"></span>
					</div>
				</li>
				<li>
					<div>�н�����</div>
					<div><input type="text" id="userPass" name="userPass" /></div>
				</li>
				<li>
					<input type="button" value="�α���" id="btnLogin" />
				</li>
			</ul>
		</div>


	 </form>

</body>
</html>