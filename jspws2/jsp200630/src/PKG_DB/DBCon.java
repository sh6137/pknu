

package PKG_DB;

import java.sql.*;

public class DBCon {

	//속성
	private String url;
	private String userID;
	private String userPwd;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	//생성자
	public DBCon() {}
	
	//생성자 오버로드
	public DBCon(String url, String userID, String userPwd) {
		this.url = url;
		this.userID = userID ;
		this.userPwd = userPwd;
	}
	
	//메써드 정의
	public Connection getConnection() {
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(this.url, this.userID, this.userPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public PreparedStatement getPreparedStatement(Connection con, String strSql) {
		
		PreparedStatement psmt = null;
		
		try {
			psmt = con.prepareStatement(strSql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return psmt;
		
	}
	
	//select일때
	public ResultSet getResultSet(String strSql) {
		
		ResultSet rs = null;
		
		Connection con = this.getConnection();
		
		PreparedStatement psmt = getPreparedStatement(con, strSql);
		
		try {
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	
	//insert,update,delete 할때
	public void setCUD(String strSql) {
		Connection con = this.getConnection();
		PreparedStatement psmt = getPreparedStatement(con, strSql);
		try {
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//proc사용할 때
	
	
}
