package preparedstatement1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {

	private   String   driver = "oracle.jdbc.OracleDriver";
	private   String   url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private   String   dbuid  = "testdb";
	private   String   dbpwd  = "1234";
	
	private   Connection         conn  = null;
	private   PreparedStatement  pstmt = null;
	private   ResultSet          rs    = null;
	
	public  DBHandler() {
		open();
	}

	public Connection open() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbuid, dbpwd);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return conn;
	}
	
	public void close() {
		try {
			if(rs    != null)  rs.close();
			if(pstmt != null)  pstmt.close();
			if(conn  != null)  conn.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}

	public List<Member> getMemberList() {
		List<Member> mlist = new ArrayList<Member>();   
		
		try {
			String  sql = "SELECT  M.MID, M.NAME, M.EMAIL, ML.MLEVEL"; 
			sql        += " FROM   MEMBER M"; 
			sql        += "  JOIN  MEMBERLEVEL ML"; 
			sql        += "   ON   M.POINT BETWEEN  ML.LOPOINT AND ML.HIPOINT";			
			sql        += "   ORDER BY M.MID ASC ";			
			pstmt  = conn.prepareStatement(sql);			
			rs     = pstmt.executeQuery();
			while( rs.next() ) {
				int     mid    = rs.getInt("mid");
				String  name   = rs.getString("name");
				String  email  = rs.getString("email");
				String  mlevel = rs.getString("mlevel");
				Member  m      = new Member(mid, name, email, mlevel);
				mlist.add( m );
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		
		return mlist;
	}

	/*
	  INSERT INTO MEMBER ( MID, NAME, EMAIL, PHONE   ) 
        VALUES ( (SELECT NVL(MAX(MID), 0)+1 FROM MEMBER),
         '원석', 'YS@NAVER.COM' , '010-2222-3333') 
	 */
	public int addMember(Member insertM) {
		int cnt = 0;
		try {
			String sql  =  "INSERT INTO MEMBER ( MID, NAME, EMAIL, PHONE )"; 
			sql        +=  " VALUES ( (SELECT NVL(MAX(MID), 0)+1 FROM MEMBER),"; 
			sql        +=  " ?, ?, ? )";
			pstmt      = conn.prepareStatement(sql);			
		/*	pstmt.setString(1, "원석"); // setString() 은 자동으로 작은따옴표(')를 추가해줌
			pstmt.setString(2, "ys@naver.com");
			pstmt.setString(3, "010-2222-3333");   */
			pstmt.setString(1,  insertM.getName()  );
			pstmt.setString(2,  insertM.getEmail() );
			pstmt.setString(3,  insertM.getPhone() );
			cnt        = pstmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} 
		return cnt;		
	}

	// 수정 : 5, "석준", "sg@naver.com", "010-6767-7878", 1000
	public int updateMember(Member updateM) {
		int  updateCnt = 0;
		
		try {
			String sql = "UPDATE  MEMBER  SET " ; 
			sql       += "  NAME      = ? "; 
			sql       += ", EMAIL     = ? "; 
			sql       += ", PHONE     = ? "; 
			sql       += ", POINT     = ? "; 
			sql       += "  WHERE  MID = ? ";			
			pstmt      =  conn.prepareCall(sql);
			pstmt.setString(1,  updateM.getName()) ;
			pstmt.setString(2,  updateM.getEmail() );
			pstmt.setString(3,  updateM.getPhone() );
			pstmt.setInt(   4,  updateM.getPoint() );
			pstmt.setInt(   5,  updateM.getMid()   );
			updateCnt  =  pstmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return updateCnt;
	}

	public int deleteMember(Member deleteM) {
		int    deleteCnt  =  0;
		try {
			String  sql = "DELETE FROM MEMBER WHERE MID = ?";
			pstmt       =  conn.prepareStatement(sql);
			pstmt.setInt(1, deleteM.getMid() );
			deleteCnt   = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return deleteCnt;
	}

	// mid 로 조회한  멤버 한사람의  전체 정보
	public Member getMember(Member selM) {
		Member  mem  = null;
		
		try {
			String sql  =  "SELECT   MID, NAME, EMAIL,  PHONE,  MLEVEL,  POINT,"; 
			sql        +=  " TO_CHAR(RDATE, 'YYYY-MM-DD HH24:MI:SS DAY') RDATE"; 
			sql        +=  " FROM "; 
			sql        +=  "  MEMBER M  JOIN  MEMBERLEVEL ML";
			sql        +=  "  ON  M.POINT BETWEEN ML.LOPOINT AND ML.HIPOINT"; 
			sql        += "  WHERE  M.MID  = ? "; 
			sql        += "  ORDER BY M.MID ASC ";
			pstmt       =  conn.prepareStatement(sql);
			pstmt.setInt( 1,  selM.getMid() );
			rs          =  pstmt.executeQuery();
			if( rs.next() ) {
				int     mid    = rs.getInt("mid");
				String  name   = rs.getString( "name" );
				String  email  = rs.getString( "email" );
				String  phone  = rs.getString( "phone" );
				String  mlevel = rs.getString( "mlevel" );
				int     point  = rs.getInt(     "point");
				String  rdate  = rs.getString( "rdate");
				mem    = new Member(mid, name, email, phone, mlevel, point, rdate);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return  mem;
	}
	
	
	

}
