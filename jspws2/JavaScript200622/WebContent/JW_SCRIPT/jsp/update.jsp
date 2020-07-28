<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page language="java" import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
   .title{ width:200px; height:40px; font-size:20px; border:1px solid #888888;
             background-color:#eeeeee;float:left; text-align:center;}
   .content{ width:400px; height:40px; font-size:20px; border:1px solid #888888; 
             background-color:#eeeeee;float:left}
   .row{clear:both;}
</style>

<script>

   //1. jquery 없이 유효성 검사
   function checkValue(){
      
      var objSid = document.getElementById("sid");
      
      //1. 학생아이디 유효성 검사
      //4자이어야 해요 그리고 S로 시작해야 해요
      if(objSid.value.length != 4 || objSid.value.substr(0,1) != 'S'){
         
         alert("학생아이디를 다시 작성하세요");
         return false;
         
      }
      
      var objName = document.getElementById("sname");
      
      //2. 학생이름 유효성 검사
      //2자이상이면 된다
      if(objName.value.length<2){
         
         alert("학생이름을 정확하게 적어주세요!!");
         return false;
      }
      

      //frmStudent.submit();
   }

</script>

<title>Insert title here</title>
</head>

<%
   //list.jsp에서 보낸 sid를 받아야 해요
   String strSid = request.getParameter("sid");

      //db연결을 하자
      //데이터베이스 students 테이블에 데이터(row)를 추가해보자
      //데이터베이스를 연동하려면 사용하는 java package
      //java.sql
      
      //0. 오라클을 연결할려면 오라클 연결정보
      String strURL = "jdbc:oracle:thin:@localhost:1521:XE";
      String useID = "testdb";
      String usePWD = "1234";

      //1. db 연결을 위한 class
      Connection conn = DriverManager.getConnection(strURL, useID, usePWD);   
      
      String strSql = "SELECT SID, SNAME, DAGE, DGEN FROM STUDENTS WHERE SID='" + strSid + "'";
      
      PreparedStatement psmt = conn.prepareStatement(strSql);
      
      ResultSet rs = psmt.executeQuery();

      rs.next();

%>


<body>

   <form action="./write_ok.jsp" method="post" name="frmStudent" onsubmit="return checkValue()">
      <div id="formWrap">
         <div class="row">
            <div class="title">
               학생아이디
            </div>
            <div class="content">
               <input type="text" id="sid" name="sid" class="itext" value="<%=rs.getString("sid")%>"/>
            </div>
         </div>
         <div class="row">
            <div class="title">
               학생이름
            </div>
            <div class="content">
               <input type="text" id="sname" name="sname" class="itext" value="<%=rs.getString("sname")%>"/>
            </div>
         </div>
         <div class="row">
            <div class="title">
               학생나이
            </div>
            <div class="content">
               <input type="text" id="sage" name="sage" class="itext" value="<%=rs.getString("dage")%>"/>
            </div>
         </div>
         <div class="row">
            <div class="title">
               학생성별
            </div>
            <div class="content">
               <label>
                  <input type="radio" id="male" name="gender"  value="M"
                     <%
                        if(rs.getString("dgen").equals("M")) { 
                           out.println("checked");
                        }
                     %>
                  /> 왕자(병)
                  
               </label>
               <label>
                  <input type="radio" id="female" name="gender"  value="F"
                     <%
                        if(rs.getString("dgen").equals("F")) { 
                           out.println("checked");
                        }
                     %>
                  /> 공주(병)
               </label>
            </div>
         </div>
         <div class="row">
            <div class="title">
               학생취미
            </div>
            <div class="content">
               <label>
                  <input type="checkbox" id="hobby1" name="hobby1"  value="1"/>자기
               </label>
               <label>
                  <input type="checkbox" id="hobby2" name="hobby2"  value="2"/> 먹기
               </label>
               <label>
                  <input type="checkbox" id="hobby3" name="hobby3"  value="3"/> 놀기
               </label>
            </div>
         </div>
         <div class="row">
            <!--  <input type="submit" value="확인" /> -->
            
            <button> 확인 </button>
            <a href="./list.jsp?sname=">리스트로</a>
            <!--<input type="button" value="확인" onclick="checkValue()" />-->
         </div>
      </div>
   </form>

</body>
</html>