<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   .title{
      width : 200px; height : 40px; font-size : 20px; border : 1px solid black; background-color : #eeeeee;
      float : left; text-align : center;
   }
   .content{
      width : 400px; height : 40px; font-size : 20px; border : 1px solid black; background-color : #eeeeee;
      float : left;
   }
   .row{
      clear : both;
   }
</style>
<script>
   //1. jquery 없이 유효성 검사
   function checkValue(){
      
      //1. 학생아이디 유효성 검사 - 4자이어야 함 / S로 시작해야함
      var objSid = document.getElementById("sid");
      if(objSid.value.length != 4 || objSid.value.substring(0, 1) != 'S'){
         alert("학생 아이디를 다시 작성하세요");
         return false;
      }
      
      //2. 학생이름 유효성 검사 - 2자이상이면 된다
      var objName = document.getElementById("sName");
      if(objName.value.length < 2){
         alert("학생 이름을 정확하게 입력하세요");
         return false;
      }
      
      //frmStudent.submit();
   }
</script>
</head>
<body>

<form action = "./write_ok.jsp" method = "post" name = "frmStudent" onsubmit = "return checkValue()">
   <div id = "formWrap">
      <div class = "row">
         <div class = "title">
            학생아이디
         </div>
         <div class = "content">
            <input type = "text" id = "sid" name = "id" class = "iText"/>
         </div>
      </div>

      <div class = "row">
         <div class = "title">
            학생이름
         </div>
         <div class = "content">
            <input type = "text" id = "sName" name = "name" class = "iText"/>
         </div>
      </div>

      <div class = "row">
         <div class = "title">
            학생나이
         </div>
         <div class = "content">
            <input type = "text" id = "sAge" name = "age" class = "iText"/>
         </div>
      </div>

      <div class = "row">
         <div class = "title">
            학생성별
         </div>
         <div class = "content">
            <label>
               <input type = "radio" id = "male" name = "gender" value = "M">남자
            </label>
            <label>
               <input type = "radio" id = "female" name = "gender" value = "F">여자
            </label>
         </div>
      </div>
      
      <div class = "row">
         <div class = "title">
            학생취미
         </div>
         <div class = "content">
            <input type = "checkbox" id = "hobby1" name = "hobby1" class = "iText"/>자기
            <input type = "checkbox" id = "hobby2" name = "hobby2" class = "iText"/>놀기
            <input type = "checkbox" id = "hobby3" name = "hobby3" class = "iText"/>먹기
         </div>
      </div>
      <div class = "row">
         <!-- <input type = "submit" id = "submit" value = "확인" onclick = "checkValue()"> -->
         <!-- <input type = "button" value = "확인" onclick = "checkValue()"/> -->   
         <button>확인</button>      
      </div>
      
   </div>
</form>

</body>
</html>