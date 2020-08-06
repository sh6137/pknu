<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

   <table>
    <tr>
     <c:forEach var="menuVo" items="${ menuList }">       
      <td>
      <a href="/PDS/List?menu_id=${ menuVo.menu_id }&nowpage=1&pagecount=${pagePdsVo.pagecount}&pagegrpnum=1">
         ${ menuVo.menu_name }
      </a>
      </td>      
      </c:forEach>      
    </tr>
  </table>

