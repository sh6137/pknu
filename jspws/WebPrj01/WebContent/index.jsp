<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
    /* jsp : 자바 명령어 코딩 */
    String name = "민성";
    String msg  = "jsp 잘되나";
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

</style>
<script>

</script>

</head>
<body>
   <h1>Hello JSP 한글 잘 되나 </h1>
   <%  out.print( name + "<br>" );    %>
   <%  out.print( msg );  %><br>
   <%= msg  %><br>
</body>
</html>