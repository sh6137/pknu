<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css" />
</head>
<body>
  <form action="/SpBoard/Update" method="POST">
  <table>
  <caption>
  <h1>수정하기</h1>
  </caption>
  <tr>
     <td>글번호</td>
     <td><input type="text" name="idx" value="${ spBoardVo.idx }" readonly /></td>
  </tr>
  <tr>
     <td>제목</td>
     <td><input type="text" name="title"  value="${ spBoardVo.title }"/></td>
  </tr>
  <tr>
     <td>이름</td>
     <td><input type="text" name="name"  value="${ spBoardVo.name }"/></td>
  </tr>
  <tr>
     <td>날짜</td>
     <td>${ spBoardVo.regdate }</td>
  </tr>
  <tr>
     <td colspan="2"><input type="submit" value="저장" /></td>
  </tr>
  </table>
  </form>
</body>
</html>