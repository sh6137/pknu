<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
     String  userid = request.getParameter("userid");
     String  passwd = request.getParameter("passwd"); 
     
     boolean bLogin = false;
     if( userid.equals("sky") && passwd.equals("1234") )  
    	 bLogin = true;
%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if ( bLogin ) {  %>
넘어온<br>
아이디 <% out.print(userid); %><br>
암호 <%=passwd %><br>
입니다
<% } else { %>
아이디나 암호를 확인하세요
<% } %>
</body>
</html>