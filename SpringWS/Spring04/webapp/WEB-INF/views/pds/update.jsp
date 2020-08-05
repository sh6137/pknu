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
   #err_title { color:red; font-weight:bold; }
</style>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
  function inputCheck() {
	  if( $("[name=title]").val() == '' ) {
		  $('#err_title').html("<b>제목을 입력하세요</b>");
		  alert('수정');
		  return false;
	  }
	  if( $("[name=writer]").val() == '' ) return false;
	  if( $("[name=cont]").val() == '' ) return false;  
	  
	  return true;
  }

  $( function() {
	  $('#form1').on('submit', function(e) {
		  var isValid = inputCheck();
		  if(isValid) {
			  return true;
		  } else {
			  return false;
		  }
	  })
  } );

</script>
</head>
<body>
   <h1>글 수정하기</h1>
   
   <%@include file="/WEB-INF/include/menus.jsp" %>
   
   <br />
   <br />
   
   <!-- 자료 입력 -->
   <form id="form1" action="/PDS/Update" method="POST" enctype="multipart/form-data">   
   <input type="hidden"  name="idx" value="${ pdsVo.idx }" />
   <input type="hidden"  name="menu_id" value="${ pdsVo.menu_id }" />
   <input type="hidden"  name="nowpage" value="${ pdsVo.nowpage }" />
   <input type="hidden"  name="pagecount" value="${ pdsVo.pagecount }" />
   <input type="hidden"  name="pagegrpnum" value="${ pdsVo.pagegrpnum }" />
   <table>
   <tr>
     <td>작성자</td>
     <td><input type="text" name="writer" value="${ pdsVo.writer }" /></td>
     <td>작성일</td>
     <td><input type="text" name="regdate" value="${ pdsVo.regdate }" /></td>        
   </tr> 
   <tr>
     <td>글번호</td>
     <td><input type="text" name="bnum" value="${ pdsVo.bnum }" /></td>
     <td>조회수</td>
     <td><input type="text" name="readcount" value="${ pdsVo.readcount }" /></td>        
   </tr> 
   <tr>
     <td>글제목</td>
     <td colspan="3">
        <input type="text" name="title" value="${ pdsVo.title }" />
        <span id="err_title"></span>
      </td>   
   </tr> 
   <tr>
     <td style="height:300px;">글내용</td>
     <td colspan="3">
        <textarea name="cont">${  pdsVo.cont  }</textarea>
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
        <input type="submit" value="수정" />
        <a href="/PDS/WriteForm?menu_id=${pdsVo.menu_id}&bnum=0&lvl=0&step=0&nref=0&nowpage=${nowpage}&pagecount=2&pagegrpnum=${pagegrpnum}">새글쓰기</a>      
        <a href="/PDS/List?menu_id=<c:out value='${map.menu_id}' />">목록</a>        
     </td>        
   </tr> 
  
   </table> 
   </form>  
</body>
</html>