<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String str = request.getParameter("param");
	
	String[] strComIDs = str.split("-");
	
	//out.println(strComIDs.length);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>



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
		}		
	);

	var getAddr = function(selectedVal, lvl, objID){
		
		var strHTML = "";
		
		$.ajax({
			url : "./Datas/getAddr.jsp",
			type : "get",
			data : "addr=" + selectedVal + "&lvl=" + lvl,
			datatype : "json",
			success : function(datas){
				
				strHTML += "<select id='addr" + lvl + "' name='addr" + lvl + "'>";
				strHTML += "<option value='-'>선택하세요</option>"
				$.each(
						datas,
						function(index, item){
							strHTML += "<option value='" + item.val + "'>" + item.txt + "</option>";
						}
				);
				strHTML += "</select>";
					
				$("#" + objID).html(strHTML);
				
				$("#addr1").val("<%=strComIDs[1]%>");
				
			}
			,
			error : function(){
				alert("err");
			}
		});
		
	}
	
	
	

</script>
</head>
<body>
<div>
	<span id="sido"></span>
	<span id="gugun"></span>
	<span id="dong"></span>
	<span id="dong2"></span>
</div>
</body>

<script>


</script>

</html>