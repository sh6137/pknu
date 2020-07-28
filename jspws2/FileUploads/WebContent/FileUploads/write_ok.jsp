<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.Enumeration"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.*"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>  
<%@ page language="java" import="PKG_DB.DBCon" %>  
<%@ page language="java" import="java.sql.*" %>

<%
	String uploadDir = request.getRealPath("uploadFiles");

	//request.getParameterNames("a");

	int maxSize = 1024 * 1024 * 1;

	//out.println(uploadDir);
	
	MultipartRequest multi = new MultipartRequest(
			request, uploadDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
	
	
	String strWrite = multi.getParameter("write");
	String strContent= multi.getParameter("content");
	
	//Write에 저장하면서 키값을 받아와야 한다.
	DBCon db = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "testdb", "1234");
	
	String strProcName = "CALL PKG_FILES.PROC_WRITE(?,?,?)";
	String[] strParams = {strWrite, strContent, ""};
	String[] strInOut = {"IN", "IN", "OUT"};
	int[] sqlTypes = {0,0, oracle.jdbc.OracleTypes.CURSOR};
	
	ResultSet rs = db.getResultSet(strProcName, strParams, strInOut, sqlTypes);
	
	rs.next();
	
	String strIDX = rs.getString("IDX");
	
	
	Enumeration files = multi.getFileNames();
	
	int i = 0;
	while(files.hasMoreElements()){
		
		String file1 = (String)files.nextElement();   //물리적 저장
		
		String orgFileName = multi.getOriginalFileName(file1); //클라이언트가 올려준 파일명
		String newFileName = multi.getFilesystemName(file1);  //중복 수정된 파일
		
		File file = multi.getFile(file1);  //실제파일
		//file.get
		
		long fileSize = file.length();
		
		String fileExt = multi.getContentType(file1);
		
		out.println(orgFileName);
		out.println(newFileName);
		out.println(fileSize);
		out.println(fileExt);
	
		
		String strProcName2 = "CALL PKG_FILES.PROC_SAVE_FILE(?,?,?,?,?)";
		String[] strParams2 = {orgFileName, newFileName, Long.toString(fileSize), fileExt, strIDX};

		db.setUpdate(strProcName2, strParams2);
		
		i += 1;
		
	}
	
	
	response.sendRedirect("../FileList");
	
	
	
	
%>