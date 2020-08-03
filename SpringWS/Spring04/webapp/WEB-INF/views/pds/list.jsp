<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>PDS List</title>
   <link rel="stylesheet" type="text/css" href="/css/style.css"/>
   <style>
      th:nth-of-type(1), td:nth-of-type(1) { width:100px; }
      th:nth-of-type(2), td:nth-of-type(2) { width:400px; }
      th:nth-of-type(3), td:nth-of-type(3) { width:150px; }
      th:nth-of-type(4), td:nth-of-type(4) { width:100px; }
      th:nth-of-type(5), td:nth-of-type(5) { width:150px; }
      th:nth-of-type(6), td:nth-of-type(6) { width:100px; }
      
      td:nth-of-type(2) { text-align:left; padding-left:10px; }
   </style>
</head>
<body>
   <h2>게시판</h2>
   
   <!-- 메뉴 -->
   <%@ include file="/WEB-INF/include/menus.jsp" %>
   
   <div class="wrapBtn">
      <div class="divBtn">
         <a href="/PDS/WriteForm?menu_id=${ menu_id }&bnum=0&lvl=0&step=0&nref=0&now_page=${ now_page }&page_grp_num=${ page_grp_num }" class="aBtn">새 글 쓰기</a>
      </div>
   </div>
   
   <!-- 목록 -->
   <table>
      <tr>
         <th>글번호</th>
         <th>제목</th>
         <th>작성자</th>
         <th>파일</th>
         <th>작성일</th>
         <th>조회수</th>
      </tr>
      <c:forEach var="pdsVo" items="${ pdsList }">
         <tr>
            <td>
               <c:choose>
                  <c:when test="${ pdsVo.lvl eq 0 }">
                     ${ pdsVo.bnum }
                  </c:when>
                  <c:otherwise>
                     
                  </c:otherwise>
               </c:choose>
            </td>
            <td>
               <c:choose>
                  <c:when test="${ pdsVo.lvl eq 0 }">
                     <c:choose>
                        <c:when test="${ pdsVo.delnum eq 0 }">
                           <a href="http://PDS/Content?idx=${ pdsVo.idx }&menu_id=${ pdsVo.menu_id }&nowpage=${ pagePdsVo.nowpage }&pagegrpnum=${ pagePdsVo.pagegrpnum }" >${ pdsVo.title }" >${ pdsVo.title }</a>
                        </c:when>
                        <c:otherwise>
                           삭제된 글입니다.
                        </c:otherwise>
                     </c:choose>
                  </c:when>
                  <c:otherwise>
                     <c:choose>
                        <c:when test="${ pdsVo.delnum eq 0 }">
                           <c:forEach var="i" begin="0" end="${ pdsVo.lvl }">
                              &nbsp;&nbsp;
                           </c:forEach>
                           <a href="http://PDS/Content?idx=${ pdsVo.idx }&menu_id=${ pdsVo.menu_id }&nowpage=${ pagePdsVo.nowpage }&pagegrpnum=${ pagePdsVo.pagegrpnum }" >${ pdsVo.title }</a>
                        </c:when>
                        <c:otherwise>
                           삭제된 글입니다.
                        </c:otherwise>
                     </c:choose>
                  </c:otherwise>
               </c:choose>
            </td>
            <td>${ pdsVo.writer }</td>
            <td>${ pdsVo.files_count }</td>
            <td>${ pdsVo.regdate }</td>
            <td>${ pdsVo.read_count }</td>
         </tr>
      </c:forEach>
   </table>
   
   <!-- 페이징처리 -->
   <%@ include file="/WEB-INF/include/paging.jsp" %>
</body>
</html>