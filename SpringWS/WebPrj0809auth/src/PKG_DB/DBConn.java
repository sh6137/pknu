package PKG_DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {

	// 속성
	private String url;
	private String uId;
	private String uPd;
	
	// 생성자
	public DBConn() {  }
	
	// 생성자 오버로드
	public DBConn(String url, String uId, String uPd) {
		this.url = url;
		this.uId = uId;
		this.uPd = uPd;
	}
	
	// getter/setter
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPd() {
		return uPd;
	}
	public void setuPd(String uPd) {
		this.uPd = uPd;
	}

	// method
	public Connection getConnection() {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(this.url, this.uId, this.uPd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;

	}
	
	public PreparedStatement getPreparedStatement(Connection conn, String sql) {
		
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return psmt;
		
	}
	
	
	// select method
	public ResultSet getResultSet(String selectSql) {
				
		Connection conn = this.getConnection();
		
		PreparedStatement psmt = getPreparedStatement(conn, selectSql);
		
		ResultSet rs = null;
		
		try {
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	// insert, update, delete method
	public void setCUD(String CUDSql) {
		
		Connection conn = this.getConnection();
		
		PreparedStatement psmt = getPreparedStatement(conn, CUDSql);
		
		try {
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public CallableStatement getCallableStatement(String strProcSql) {
		
		Connection conn = getConnection();
		
		CallableStatement csmt = null;
		try {
			csmt = conn.prepareCall(strProcSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return csmt;
	}
	
	// procedure method
	public ResultSet getResultSet(String strProcSql, String [] strInParams, String [] strInOut, int [] sqlTypes) {
									// prosql			inout매개변수			in?out?			if out? pleas type
		
		//Connection conn = this.getConnection(); 필요없음
		ResultSet rs = null;
		
		try {
			
			//CallableStatement csmt = conn.prepareCall(strprocSql);
			//csmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
			//csmt.execute();
			//rs = (ResultSet)csmt.getObject(1);
			
			CallableStatement csmt = this.getCallableStatement(strProcSql);
			
			for (int i = 0; i < strInParams.length; i++) {
				
				if(strInOut[i] == "IN") {
					
					csmt.setString((i+1), strInParams[i]);
					
				} else { // out 이면?
					
					csmt.registerOutParameter((i+1), sqlTypes[i]);
					csmt.execute();
					rs = (ResultSet)csmt.getObject(i+1);
					
				}
    
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	// 프로시저를 사용해서 저장(수정, 추가) 삭제 사용
	public int setUpdate(String strProcSql, String [] strParams) {
		
		
		int upCnt = 0;
		
		CallableStatement csmt = this.getCallableStatement(strProcSql);
		
		for (int i = 0; i < strParams.length; i++) {
			
			try {
				csmt.setString(i+1, strParams[i]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		try {
			upCnt = csmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return upCnt;
		
	}

}
