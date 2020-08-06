<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css" />
<style>
   textarea { width:400px; height: 150px; }
</style>
</head>
<body>
   <h1>글 쓰기</h1>
   
   <%@include file="/WEB-INF/include/menus.jsp" %>
   
   <br />
   <br />
   
   <!-- 자료 입력 -->
   <form action="/PDS/Write?a=1234"  method="POST"  enctype="multipart/form-data">
   <table>
   <tr>
     <td>작성자</td>
     <td>
        <input type="text" name="writer" value="${ map.user_id }" />
      </td>   
   </tr> 
   <tr>
     <td>글제목</td>
     <td>
        <input type="text" name="title"  />
      </td>   
   </tr> 
   <tr>
     <td>글내용</td>
     <td>
        <textarea name="cont" ></textarea>
      </td>   
   </tr> 
   <tr>
     <td>파일</td>
     <td>
        <input type="file" name="upfile" />
        <input type="file" name="upfile2" />
        <input type="file" name="upfile3" />
        <input type="file" name="upfile4" />
      </td>   
   </tr> 
   <tr>
     <td colspan="2"><input type="submit" value="확인" /></td>        
   </tr> 
   <tr>
     <td colspan="2" style="text-align:right">
        <a href="/PDS/List?menu_id=<c:out value='${map.menu_id}' />">목록</a>        
     </td>        
   </tr> 
  
   </table> 
   <input type="hidden" name="menu_id" value="<c:out value='${ map.menu_id}' />" />
   <input type="hidden" name="bnum" value="<c:out value='${ map.bnum}' />" />
   <input type="hidden" name="lvl" value="<c:out value='${ map.lvl}' />" />
   <input type="hidden" name="step" value="<c:out value='${ map.step}' />" />
   <input type="hidden" name="nref" value="<c:out value='${ map.nref}' />" />

   <input type="hidden" name="nowpage" value="<c:out    value='${ map.nowpage}' />" />
   <input type="hidden" name="pagegrpnum" value="<c:out value='${ map.pagegrpnum}' />" />
   <input type="hidden" name="pagecount" value="<c:out  value='${ map.pagecount}' />" />
   </form>
   
</body>
</html>