package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {
	
	//fields
	private String  driver = "oracle.jdbc.OracleDriver";
	private String  url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private String  dbuid  = "testdb";
	private String  dbpwd  = "1234"; 
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	//생성자
	public DBHandler() {
		open();
	}

	public void open() {
		try {
			Class.forName(driver);
			conn        = DriverManager.getConnection(url,dbuid, dbpwd);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(rs != null )rs.close();
			if(stmt != null)rs.close();
			if(conn != null )conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	//member 목록 조회 MID, NAME, EMAIL, ML.MLEVEL,RDATE
	public List<Member> getmemberList() {
		List<Member> list = new ArrayList<Member>();
		try {
			stmt        = conn.createStatement();
			
			String sql = "SELECT MID, NAME, EMAIL, ML.MLEVEL, "; 
				   sql +="TO_CHAR(RDATE, 'YYYY-MM-DD') RDATE " ;
				   sql +="FROM MEMBER M, MEMBERLEVEL ML " ;
				   sql +="WHERE M.POINT BETWEEN ML.LOPOINT AND ML.HIPOINT";
			rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next()) {
				int mid = 			rs.getInt("mid");
				String name = 		rs.getString("name");
				String email =		rs.getString("email");
				String mlevel = 	rs.getString("mlevel");
				String rdate =   	rs.getString("rdate");
				Member m = new Member(mid, name, email, mlevel,rdate);
				
				list.add(m);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	//개인조회
	public Member getmember(int mid) {
		Member m =  null;
		
		try {
			stmt = conn.createStatement();
			String sql = "SELECT MID, NAME, EMAIL, PHONE, ";
				   sql += "POINT, ML.MLEVEL, "; 
				   sql += "TO_CHAR(RDATE, 'YYYY-MM-DD DAY') RDATE ";
				   sql += "FROM MEMBER M, MEMBERLEVEL ML ";
				   sql += "WHERE M.POINT BETWEEN ML.LOPOINT AND ML.HIPOINT "; 
				   sql += "AND MID= " + mid;
				   rs = stmt.executeQuery(sql);
				   
				   if(rs.next()) {
					   String name = rs.getString("name");
					   String email = rs.getString("email");
					   String phone = rs.getString("phone");
					   int point = rs.getInt("point");
					   String mlevel = rs.getString("mlevel");
					   String rdate = rs.getString("rdate");
					   m = new Member(mid, name, email, phone, point, mlevel, rdate);
					   
				   }else {
					   m = null;
				   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
	public int addMember(Member m) {
		int aftcnt =0;
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO MEMBER(MID,NAME,EMAIL,PHONE) ";
				   sql+= "VALUES((SELECT  NVL(MAX(MID),0) + 1 FROM MEMBER), "; 
				   sql+= "'"+m.getName()+"',";
				   sql+= "'"+m.getEmail()+"',";
				   sql+= "'"+m.getPhone()+"')";
			aftcnt = stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aftcnt;
		
	}
	
	public Member updateMember(int mid2, Member m2) {
		
		
		try {
			stmt = conn.createStatement();
			String sql = "UPDATE MEMBER ";
				   sql+= "SET NAME = " +"'"+ m2.getName() + "',";
				   sql+= "EMAIL	   = " +"'"+ m2.getEmail() +"',";
				   sql+= "PHONE	   = " +"'"+ m2.getPhone() +"',";
				   sql+= "POINT=2000 "; 
				   sql+= "WHERE MID= " + mid2;
				   
				   rs = stmt.executeQuery(sql);
				   
				   if(rs.next()) {
					   String name = rs.getString("name");
					   String email = rs.getString("email");
					   String phone = rs.getString("phone");
					   int point = rs.getInt("point");
					   String mlevel = rs.getString("mlevel");
					   String rdate = rs.getString("rdate");
					   m2 = new Member(mid2, name, email, phone, point, mlevel, rdate);
					   
				   }else {
					   m2 = null;
				   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m2;
		
		
		
	}

	public int delMember(int delmid) {
		int cnt =0;
		try {
			stmt = conn.createStatement();
			String sql = "DELETE FROM MEMBER";
			sql += " WHERE MID = " + delmid;
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
}
