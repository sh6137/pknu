<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="PKG_DB.DBConn" %>
<%@ page language="java" import="java.sql.*"  %>
<%@ page language="java" import="org.json.simple.*"  %>

<%

	String strMenuID = request.getParameter("mainmenuID");

	DBConn dbConn = new DBConn("jdbc:oracle:thin:@localhost:1521:xe", "auth", "1234");

	String strProcSql = "CALL PKG_MENUS.PROC_SEL_SUBMENUS(?, ?)";
	String	[] strInParams	= { strMenuID, ""};
	String	[] strInOut		= { "IN", "OUT" };
	int		[] sqlTypes		= { 0, oracle.jdbc.OracleTypes.CURSOR };

	ResultSet rs = dbConn.getResultSet(strProcSql, strInParams, strInOut, sqlTypes);
	
	
	JSONArray arr = new JSONArray();
	while(rs.next()) {
		
		JSONObject obj = new JSONObject();
		//MENUNAME, MENUSEQ, MENULVL, MENUID, PARENTID
		obj.put("menuname", rs.getString("MENUNAME"));
		obj.put("menuseq", rs.getString("MENUSEQ"));
		obj.put("menulvl", rs.getString("MENULVL"));
		obj.put("menuid", rs.getString("MENUID"));
		obj.put("parentid", rs.getString("PARENTID"));
		obj.put("pfilename", rs.getString("PFILENAME"));
		
		arr.add(obj);
		
	}
	
	response.setContentType("Application/json");
	out.println(arr);
	
%>