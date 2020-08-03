<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<div style="text-align:center">
   <table>
      <tr>
         <td>
            <c:set var="showprev"       value="${ pagePdsVo.isshowpageprev }" />
            <c:set var="shownext"       value="${ pagePdsVo.isshowpagenext }" />

            <c:set var="startnum"       value="${ pagePdsVo.pagestartnum }" />
            <c:set var="endnum"       value="${ pagePdsVo.pageendnum }" />
            <c:set var="pagegrpnum"    value="${ pagePdsVo.pagegrpnum }" />

            <c:set var="recordcount"    value="${ pagePdsVo.recordcount }" />
            <c:set var="pagecount"       value="${ pagePdsVo.pagecount }" />
            <c:set var="totalpagecount" value="${ pagePdsVo.totalpagecount }" />

            <c:set var="tnowpage"       value="${ pagePdsVo.nowpage }" />
            <c:set var="prevnowpage"    value="${ pagePdsVo.prevnowpage}" />
            <c:set var="nextnowpage"    value="${ pagePdsVo.nextnowpage}" />

            <c:set var="menu_id"       value="${ pagePdsVo.menu_id}" />
            
            <c:if test="$showprev eq true}">
               ◀[이전 ${ pagecount }개]
            </c:if>
            
            <c:forEach var="pagenum" begin="${ startnum }" end="${ endnum }" step="1">            
               <a href="/PDS/List?menu_id=${ menu_id }&nowpage=${ nowpage }&pagecount=${pagecount}&pagegrpnum=${pagegrpnum}">${ pagenum }</a> &nbsp;&nbsp;
            </c:forEach>
            
            <c:if test="${ shownext eq true }">
               ▶[다음 ${ pagecount }개]
            </c:if>
         </td>
      </tr>
   </table>
</div>