<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
   <link rel="stylesheet" type="text/css" href="./css/students.css">
   <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
   <script src="./js/students2.js"></script>
   <script>
      $(document).ready (
         function() {
            /*
            // 1. 매개변수
            var strURL      = "./datas/studentList.jsp";
            var strType     = "post";
            var strData     = "";
            var strDataType = "json";
            
            var strHTML = setAjax(strURL, strType, strData, strDataType);
            
            alert(strHTML);
            $("#list").html(strHTML);
            
            
            // 2. parameter들을 배열로 생성
            var arrParams = [];
            arrParams[0] = "./datas/studentList.jsp";
            arrParams[1] = "post";
            arrParams[2] = "";
            arrParams[3] = "json";
            
            getListArr(arrParams);
            */
            
            // 3. object를 활용한 호출
        	 var objParams = {
     				strURL : "./datas/studentList.jsp",
     				strType : "post",
     				strData : "",
     				strDataType : "json",
     				objHTML : $("#list")
     			};
     			
     			var strHTML = getList_obj(objParams);
            
         }   
      );
   </script>
</head>
<body>
   <div id="wrap">
      <div id="titleRow">
         <div id="tSid" class="tTd">
            아이디
         </div>
         <div id="tSname" class="tTd">
            성명
         </div>
         <div id="tAge" class="tTd">
            나이
         </div>
      </div>
      <div id="list">
         <!--
         <div id="rows">
            <div id="sid" class="sTd">
            
            </div>
            <div id="sname" class="sTd">
            
            </div>
            <div id="age" class="sTd">
            
            </div>
         </div>
         -->
      </div>
   </div>
</body>
</html>