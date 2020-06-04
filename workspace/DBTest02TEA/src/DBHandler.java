import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {
	
	// Fields
	private String  driver = "oracle.jdbc.OracleDriver";
	private String  url    = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String  dbuid  = "testdb2";
	private String  dbpwd  = "1234";
	
	private Connection conn;
	private Statement  stmt;
	private ResultSet  rs;
	
	// 생성자
	public   DBHandler() {
		open();
	}

	public void open() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbuid, dbpwd);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}	
		
	}
	
	public void close() {
		try {
			if(rs   != null ) rs.close();
			if(stmt != null ) stmt.close();
			if(conn != null ) conn.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}

	// member 목록 조회  MID, NAME, EMAIL, ML.MLEVEL, RDATE
	public List<Member> getMemberList() {
		List<Member> list = new ArrayList<Member>();
		
		try {
			stmt           =  conn.createStatement();			
			String    sql  = "SELECT   MID, NAME, EMAIL, ML.MLEVEL, "; 
			sql           += " TO_CHAR(RDATE, 'YY-MM-DD') RDATE"; 
			sql           += " FROM    MEMBER M, MEMBERLEVEL ML"; 
			sql           += " WHERE   M.POINT  BETWEEN ML.LOPOINT AND ML.HIPOINT";
			rs             = stmt.executeQuery(sql);
			while( rs.next() ) {
				int      mid     = rs.getInt("mid");
				String   name    = rs.getString("name");
				String   email   = rs.getString("email");
				String   mlevel  = rs.getString("mlevel");
				String   rdate   = rs.getString("rdate"); 
				Member m = new Member(mid, name, email, mlevel, rdate); 
				list.add(m);
			} 
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return    list;
	}

	// 게인조회
	public Member getMember( int mid ) {
		Member     m = null;				
		try {		
			stmt         = conn.createStatement();		
			String  sql  = "SELECT   MID, NAME, EMAIL, PHONE,"; 
			sql         += "  POINT, ML.MLEVEL,"; 
			sql         += "  TO_CHAR(RDATE, 'YYYY-MM-DD DAY') RDATE";
			sql         += " FROM    MEMBER M, MEMBERLEVEL ML"; 
			sql         += " WHERE   M.POINT  BETWEEN ML.LOPOINT AND ML.HIPOINT"; 
			sql         += "  AND    M.MID = " + mid; 
			rs           = stmt.executeQuery(sql);
			if(  rs.next()  ) {
				String  name    = rs.getString("name");
				String  email   = rs.getString("email");
				String  phone   = rs.getString("phone");
				int     point   = rs.getInt("point");
				String  mlevel  = rs.getString("mlevel");
				String  rdate   = rs.getString("rdate");
				
				m = new Member(mid, name, email, phone, point, mlevel, rdate);
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return   m;
	}

	public int  addMember(Member m) {
		int aftcnt  = 0;
		try {
			System.out.println("addMemembr 1.");
			System.out.println("stmt" + conn);
			stmt       =   conn.createStatement();
			System.out.println("stmt" + stmt);
			String sql =   "INSERT INTO MEMBER ( MID, NAME, EMAIL, PHONE )"; 
			sql       +=   " VALUES (  (SELECT NVL(MAX(MID),0) + 1 FROM MEMBER),"; 
			sql       +=   " '" + m.getName()    + "',";
			sql       +=   " '" + m.getEmail()   + "',";
			sql       +=   " '" + m.getPhone()   + "')";
		//	System.out.println("sql1(insert):" + sql);
			aftcnt =   stmt.executeUpdate(sql);
			System.out.println("addMemembr 2.");
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		System.out.println("addMemembr 3.");
		return aftcnt;
	}

	public int delMember(int del_mid) {
		int cnt =0;
		try {
			stmt       = conn.createStatement();
			String sql = "DELETE FROM MEMBER ";
			sql       += " WHERE MID = " +  del_mid;
			cnt        =  stmt.executeUpdate(sql);
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return cnt;
	}

	public int updateMember(Member um) {
		int  cnt  = 0;
		try {
			stmt        = conn.createStatement();
			String sql  = " UPDATE   MEMBER  SET ";
			sql        += "  NAME   = '"    + um.getName()    + "',";
			sql        += "  EMAIL  = '"    + um.getEmail()   + "',";
			sql        += "  PHONE  = '"    + um.getPhone()   + "',";
			sql        += "  POINT  = "     + um.getPoint();
			sql        += "  WHERE  MID = " + um.getMid();
			cnt  = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	
	
	
	
	
	
	
	
	
	
}
