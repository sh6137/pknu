<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="PKG_DB.DBCon" %>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="org.json.simple.JSONArray" %>
<%@ page language="java" import="org.json.simple.JSONObject" %>
<%@ page language="java" import="org.json.simple.parser.JSONParser" %>

<%
	DBCon db = new DBCon("jdbc:oracle:thin:@localhost:1521:XE", "testdb", "1234");
	String strJSONDatas = request.getParameter("jsonDatas");
	System.out.println(strJSONDatas);
	JSONParser parser = new JSONParser();
	
	JSONObject jsonObj = (JSONObject)parser.parse(strJSONDatas);
	
	JSONArray arrAppend = (JSONArray)jsonObj.get("appended");
	JSONArray arrDelete = (JSONArray)jsonObj.get("deleted");
	JSONArray arrUpdate = (JSONArray)jsonObj.get("updated");
	//추가
	int appendSize = arrAppend.size();
	
	String strProcName = "CALL PKG_SCORES.PROC_INS_COM(?,?,?,?)";
	String[] strParams = new String[4];
	for(int i =0; i < appendSize; i++){
		JSONObject obj = (JSONObject)arrAppend.get(i);
		String strGrpID = (String)obj.get("grp_id");
		String strComID = (String)obj.get("com_id");
		String strComLvl = (String)obj.get("com_lvl");
		String strComVal = (String)obj.get("com_val");
		String strParentID = (String)obj.get("parent_id");
		String strStatus = (String)obj.get("status");
		
		strParams[0] = strGrpID;
		strParams[1] = strComVal;
		strParams[2] = strComLvl;
		strParams[3] = strParentID;
		
		db.setUpdate(strProcName ,strParams);
		
		
	}
	//추가완료
	
	
	//삭제
	int deleteSize = arrDelete.size();
	String strProcName2 = "CALL PKG_SCORES.PROC_DEL_COM(?,?)";
	String[] strParams2 = new String[2];
	
	for(int i =0; i < deleteSize; i++){
		JSONObject obj = (JSONObject)arrDelete.get(i);
		
		String strGrpID = (String)obj.get("grp_id");
		String strComID = (String)obj.get("com_id");
		String strComLvl = (String)obj.get("com_lvl");
		String strComVal = (String)obj.get("com_val");
		String strParentID = (String)obj.get("parent_id");
		String strStatus = (String)obj.get("status");
		
		strParams2[0] = strGrpID;
		strParams2[1] = strComID;
		
		
		db.setUpdate(strProcName2 ,strParams2);
		
	}
	//삭제완료
	
	int updateSize = arrUpdate.size();
	
	String strProcName3 = "CALL PKG_SCORES.PROC_UP_COM(?,?,?,?)";
	String[] strParams3 = new String[2];
	
	for(int i =0; i < updateSize; i++){
		JSONObject obj = (JSONObject)arrUpdate.get(i);
		
		String strGrpID = (String)obj.get("grp_id");
		String strComID = (String)obj.get("com_id");
		String strComLvl = (String)obj.get("com_lvl");
		String strComVal = (String)obj.get("com_val");
		String strParentID = (String)obj.get("parent_id");
		String strStatus = (String)obj.get("status");
		
		strParams3[0] = strGrpID;
		strParams3[1] = strComID;
		strParams3[2] = strComVal;
		strParams3[3] = strComLvl;
		
		
		db.setUpdate(strProcName3 ,strParams3);
		
	}
	
%>