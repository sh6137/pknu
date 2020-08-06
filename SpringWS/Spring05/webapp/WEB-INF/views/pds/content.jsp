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
   <h1>글 내용보기</h1>
   
   <%@include file="/WEB-INF/include/menus.jsp" %>
   
   <br />
   <br />
   
   <!-- 자료 입력 -->   
   <table>
   <tr>
     <td>작성자</td>
     <td>${ pdsVo.writer }</td>
     <td>작성일</td>
     <td>${ pdsVo.regdate }</td>        
   </tr> 
   <tr>
     <td>긃번호</td>
     <td>${ pdsVo.bnum }</td>
     <td>조회수</td>
     <td>${ pdsVo.readcount }</td>        
   </tr> 
   <tr>
     <td>글제목</td>
     <td colspan="3">
        ${ pdsVo.title }
      </td>   
   </tr> 
   <tr>
     <td style="height:300px;">글내용</td>
     <td colspan="3">
        ${  pdsVo.cont  }
      </td>   
   </tr> 
   <tr>
     <td>파일</td>
     <td colspan="3">
        <c:forEach var="fileVo" items="${ fileList }">
          <div>
          <a href="<c:out value='/download/external/${fileVo.filename }' />">
            ${ fileVo.filename }
          </a>
          </div>
        </c:forEach>
      </td>   
   </tr>    
   <tr>
     <td colspan="4" style="text-align:right">
        <a href="/PDS/WriteForm?menu_id=${pdsVo.menu_id}&bnum=0&lvl=0&step=0&nref=0&nowpage=${nowpage}&pagecount=2&pagegrpnum=${pagegrpnum}">새글쓰기</a>
        <a href="/PDS/WriteForm?menu_id=${pdsVo.menu_id}&bnum=${pdsVo.bnum}&lvl=${pdsVo.lvl}&step=${pdsVo.step}&nref=${pdsVo.nref}&nowpage=${nowpage}&pagecount=2&pagegrpnum=${pagegrpnum}">답글쓰기</a>
        
        <c:if test="${pdsVo.writer eq login.userid}">
        <a href="/PDS/UpdateForm?idx=${pdsVo.idx}&menu_id=${pdsVo.menu_id}&nowpage=${nowpage}&pagecount=2&pagegrpnum=${pagegrpnum}">수정</a>
        <a href="/PDS/Delete?idx=${pdsVo.idx}&lvl=${pdsVo.lvl}&step=${pdsVo.step}&nref=${pdsVo.nref}&menu_id=${pdsVo.menu_id}&nowpage=${nowpage}&pagecount=2&pagegrpnum=${pagegrpnum}">삭제</a>
        </c:if>
        
        <a href="/PDS/List?menu_id=<c:out value='${map.menu_id}' />">목록</a>        
     </td>        
   </tr> 
  
   </table> 
     
</body>
</html>