<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language = "java" import = "java.sql.*"%>
<%@ page language = "java" import = "org.json.simple.*"%>

<%
   String strUserId = request.getParameter("userID");
   String strUserName = request.getParameter("userName");
   String strUserPass = request.getParameter("userPass");
   
   System.out.println(strUserId);
   System.out.println(strUserName);
   System.out.println(strUserPass);
   
   
   String url = "jdbc:oracle:thin:@localhost:1521:xe";
   String dbUid = "testdb";
   String dbPwd = "1234";
   
   Class.forName("oracle.jdbc.driver.OracleDriver");
   
   Connection conn = DriverManager.getConnection(url, dbUid, dbPwd);
   
   String strSql = "INSERT INTO MEMBERS(USERID, USERNAME, USERPASS) VALUES(?, ?, ?)";
   
   PreparedStatement psmt = conn.prepareStatement(strSql);
   psmt.setString(1, strUserId);
   psmt.setString(2, strUserName);
   psmt.setString(3, strUserPass);
   
   JSONObject obj = new JSONObject();
   obj.put("suc", "1");
   
   JSONArray arr = new JSONArray();
   arr.add(obj);
   
   psmt.executeUpdate();
   response.setContentType("Application/json");//그냥 보내면 html로 인식하므로 json타입으로 보내기 위해
   out.print(arr);

%>