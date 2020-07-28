<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="PKG_FILE.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	ArrayList<FileVO> arr = (ArrayList<FileVO>)request.getAttribute("fileList");
%>
<body>
<table border="1" cellpadding="0" cellspacing="0" width="600" align="center">
<%
	for(FileVO item : arr){
	String strIDX = item.getIdx();
	String strName = item.getName();
	String strOrgFileName = item.getOrgFileName();
	String strNewFileName = item.getNewFileName();
	String strFileSize = item.getFilesize();
%>
	
			
				<tr>
					<td width="150" align="center">
					<%=strIDX %>
					</td>
					<td width="150" align="center">
					<%=strName %>
					</td>
					<td width="150" align="center">
					<a href="download.jsp?org=<%=strOrgFileName %>&new=<%=strNewFileName%>"><%=strOrgFileName %></a>
					</td>
					<td width="150" align="center">
					<%=strFileSize %>
					</td>
				</tr>
			

<%
	}
%>
</table>

</body>
</html>