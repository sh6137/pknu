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
   
   /*
   #pdslist:nth-of-type(1) { width:1000px; } 
   #pdslist:nth-of-type(2) { width:200px; } 
   #pdslist:nth-of-type(3) { width:100px; } 
   #pdslist:nth-of-type(4) { width:100px; } 
   #pdslist:nth-of-type(5) { width:100px; } 
   #pdslist:nth-of-type(6) { width:200px; }
  */
</style>
</head>
<body>
   <h1>자료실</h1>
   
   <!--  메뉴 -->
   <%@include file="/WEB-INF/include/menus.jsp" %>
   
    <table id="pdslist">
	<tr>
	  <td>번호</td> 
	  <td>제목</td> 
	  <td>작성자</td> 
	  <td>조회수</td> 
	  <td>파일첨부</td> 
	  <td>작성일</td> 
	</tr>
  
   <!--  목록 -->
   <c:forEach  var="pdsVo"  items="${ pdsList }">
     <tr>
      <td >
         <c:choose>
           <c:when test="${ pdsVo.lvl eq 0 }">
              ${ pdsVo.bnum }
           </c:when>         
           <c:otherwise>    
                  
           </c:otherwise>
         </c:choose>      
      </td> 
	 
	  <td style="padding-left:${pdsVo.lvl * 30}px">
	  <c:choose>	    
	    <c:when  test="${ pdsVo.lvl eq 0  }">
	      <c:choose>
	        <c:when test="${ pdsVo.delnum eq 0 }">
	          <a href="/PDS/Content?idx=${pdsVo.idx}&menu_id=${pdsVo.menu_id}&nowpage=${pagePdsVo.nowpage}&pagegrpnum=${pagePdsVo.pagegrpnum}">
	           ${ pdsVo.title }
	          </a>
	        </c:when>
	        <c:otherwise>
	          삭제된 글입니다 
	        </c:otherwise>
	      </c:choose>
	  	</c:when>	    
	    <c:otherwise>
	    	<c:choose>
	        <c:when test="${ pdsVo.delnum eq 0 }">
	          <a href="/PDS/Content?idx=${pdsVo.idx}&menu_id=${pdsVo.menu_id}&nowpage=${pagePdsVo.nowpage}&pagegrpnum=${pagePdsVo.pagegrpnum}">
	           ${ pdsVo.title }
	          </a>
	        </c:when>
	        <c:otherwise>
	          삭제된 글입니다 
	        </c:otherwise>
	      </c:choose>
	    </c:otherwise>   
	  </c:choose>
	  </td>
	  <td>
	  ${pdsVo.writer}
	  ${login.userid}
	  </td>
	  <td>${ pdsVo.readcount }</td> 
	  <td>${ pdsVo.filescount }</td> 
	  <td>${ pdsVo.regdate }</td>
     </tr>   
   </c:forEach> 
   </table>
  
   <!--  페이징 처리 -->
   <%@include file="/WEB-INF/include/paging.jsp" %>
     
   <a href="/logout">로그아웃</a>
   <a href="/PDS/WriteForm?menu_id=${menu_id}&bnum=0&lvl=0&step=0&nref=0&nowpage=${nowpage}&pagecount=2&pagegrpnum=${pagegrpnum}&a=${param.a}">새글쓰기</a>
   
</body>
</html>