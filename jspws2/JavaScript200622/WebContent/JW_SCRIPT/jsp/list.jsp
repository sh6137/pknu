<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page language = "java" import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   .cls0{ width : 50px; height : 30px; border : 1px solid #999999; text-align : center; font-size : 20px; float : left; }
   .cls1{ width : 100px; height : 30px; border : 1px solid #999999; text-align : center; font-size : 20px; float : left; }
   .cls2{ width : 100px; height : 30px; border : 1px solid #999999; text-align : center; font-size : 20px; float : left;}
   .cls3{ width : 100px; height : 30px; border : 1px solid #999999; text-align : center; font-size : 20px; float : left;}
   .cls4{ width : 100px; height : 30px; border : 1px solid #999999; text-align : center; font-size : 20px; float : left;}
   .row {
         clear:both;
      }
</style>
<script>
   function Del(){
      //1. check된 놈들의 value값을 찾는다
      var checkedSids = [];
      var num = 0;
      var objChks = document.getElementsByName("chk");
      
      for (var i = 0; i < objChks.length; i++) {
         if(objChks[i].checked){
            checkedSids[num] = objChks[i].value;
            num += 1;
         }
      }
      
      var serverParams = "(";
      for (var i = 0; i < checkedSids.length; i++) {
         if(i == (checkedSids.length - 1)){
            serverParams += "'" + checkedSids[i] + "'"            
         }else
            serverParams += "'" + checkedSids[i] + "',"
      }
      serverParams += ")";
      //serverParams 
      	//서버로 보내자 (DELETE.JSP)
      	location.href = "./delete.jsp?a=" +serverParams ;
      	
   }//Del()
   
   function go
</script>
</head>
<%
   String strSName = request.getParameter("sname");
   //DB table에 데이터 넣기
   //DB 연동시 사용하는 java package -> java.sql
   
   //0.오라클 연결정보
   //String driver = "oracle.jdbc.OracleDriver";
   String url = "jdbc:oracle:thin:@localhost:1521:xe";
   String dbUid = "testdb";
   String dbPwd = "1234";
   
   //1. db연결을 위한 class
   Connection conn = DriverManager.getConnection(url, dbUid, dbPwd); 
   
      String strSql  = "";
       strSql += "SELECT SID, SNAME, DAGE, DECODE(DGEN, 'M', '남자', '여자') AS DGEN ";
       strSql += "FROM STUDENTS ";
       strSql += "WHERE SNAME LIKE '%" +strSName+ "%' ";
       strSql += "ORDER BY SID";

   PreparedStatement psmt = conn.prepareStatement(strSql);
   
   ResultSet rs = psmt.executeQuery();
%>
<body>
   <div id = "wrap">
   
      <div>
         <form action = "" method = "">
            이름검색 : <input type = "text" name = "sname" size = "10"/>
            <input type = "submit" value = "검색"/>
            <input type = "button" value = "삭제" onclick = "Del();"/>
         </form>
      </div>
      <div id = "" class = "row">
         <div class = "cls0"></div>
         <div class = "cls1">아이디</div>
         <div class = "cls2">이름</div>
         <div class = "cls3">나이</div>
         <div class = "cls4">성별</div>
      </div>
      
      <%
         while(rs.next()){
      %>
      
      <div id = "" class = "row">
         <div class = "cls0"><input type = "checkbox" name = "chk" value = "<%=rs.getString("sid") %>"></div>
         <div class = "cls1"><%=rs.getString("sid") %></div>
         <div class = "cls2"><%=rs.getString("sname") %></div>
         <div class = "cls3"><%=rs.getString("dage") %></div>
         <div class = "cls4"><%=rs.getString("dgen") %></div>
     	 <div class = "cls4"><a href = "./update.jsp?sid=">수정</a></div>
     	 
      </div>
      
      <%
         }
      %>
   </div>

</body>
</html>