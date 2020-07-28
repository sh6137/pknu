<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.txt {width:100%;height:60px;border:1px solid pink;}
</style>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
var gUpdate = function(strID, strContnet, strDivID, strConID, strIDX){
	
	var txtID = "txt" + strIDX;
	var strHTML = "<textarea id='" + txtID + "'>" + strContnet + "</textarea>";
	$("#" + strID).html(strHTML);
	

	//1.수정을 클릭하면 -> 확인 div를 보여주고
	$("#" + strDivID).hide();
	$("#" + strConID).show();
	//2.확인을 클릭하면 ->
	
}

var Go_Update = function(strIDX){
	
	var txtID = "txt" + strIDX;
	
	var txtValue = $("#" + txtID).val();
	
	//location.href="update.jsp?idx=" + strIDX + "&contents=" + txtValue;
	
	$("#hIdx").val(strIDX);
	$("#hContents").val(txtValue);
	
	hidForm.submit();
	
}
	
</script>
</head>
<%
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "testdb";
	String pwd = "1234";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	//1. CONNECTION 
	Connection con = DriverManager.getConnection(url, user, pwd);

	String strProc = "call PROC_SELECT(?,?,?,?)";
	CallableStatement cstmt = con.prepareCall(strProc);
	cstmt.setString(1, "");
	cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
	cstmt.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
	cstmt.registerOutParameter(4, oracle.jdbc.OracleTypes.CURSOR);

	cstmt.execute();

	
	String strName  = (String)cstmt.getObject(2);
	ResultSet rs1 = (ResultSet)cstmt.getObject(3);
	ResultSet iRs = (ResultSet)cstmt.getObject(4);
	
	out.println(strName);
	
	rs1.next();
	
	out.println(rs1.getString("VAL"));


%>


<body>
<table border="0" cellpadding="0" cellspacing="0" width="500" align="center">
	
		<tr>
			<td width="500" align="right" height="30" colspan="2">
				<a href="./write.jsp">글쓰기</a>
			</td>
		</tr>
	
	<%
		while(iRs.next()){
	%>
		<tr>
			<td width="120" align="left" height="30"><%=iRs.getString("NAME") %></td>
			<td width="380" height="30" align="right"><%=iRs.getString("REGDATE") %></td>
		</tr>
		<tr>
			<td width="500" align="left" height="30" colspan="2">
				<%
					String conID = "contents" + iRs.getString("idx");
				%>
				<div id="<%=conID%>">
					<%=iRs.getString("CONTENTS") %>
					<br/>
					<%=conID%> 
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2" width="500" height="1" style="background-color:#444444"></td>
		</tr>
		<tr>
			<td colspan="2" width="500" height="30" align="right">
				<%
					String strDivID = "btnDiv" + iRs.getString("idx");
					String strConID = "btnCon" + iRs.getString("idx");
				%>
				<div id="<%=strDivID%>">
					<input type="password" name="pwd" id="pwd" />
					<a href="javascript:gUpdate('<%=conID%>', '<%=iRs.getString("CONTENTS") %>', '<%=strDivID%>', '<%=strConID%>', <%=iRs.getString("IDX")%>)">수정</a>
					<a href="delete.jsp?idx=<%=iRs.getString("IDX") %>">삭제</a>
				</div>
				<div id="<%=strConID%>" style="display:none">
					<a href="javascript:Go_Update(<%=iRs.getString("IDX") %>)">확인</a>
				</div>
			</td>
		</tr>
	<%
		}
	%>
	</table>
	
	
	<form name="hidForm" action="./update.jsp"  method="post">
		<input type="hidden" id="hIdx" name="hIdx" />
		<input type="hidden" id="hContents" name="hContents" />
	</form>
</body>
</html>