<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	/* 자바코딩 */
%>

	<select id = "bYear">
		
		<%
			String strHTML = "";
			for(int i = 1901 ; i <=2020 ; i++){
				strHTML += "<option value = '" + i + "'>" + i + "</option>";
			}
			out.println(strHTML);
		
		%>
		
	</select>
</body>
</html>