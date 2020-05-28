package ex06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMain {

	private static String driver = "oracle.jdbc.OracleDriver";
	//private static String url    = "jdbc:oracle:thin:@210.179.12.120:1521:xe";
	private static String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static String dbuid  = "hrd202";
	private static String dbpwd  = "1234";
		
	public static void main(String[] args) {
		
		/*
		Student s1 = new Student("주희", "010-9999-9876" ); 
		addStudent("민성", "010-1234-4321");
		addStudent( s1 );
		*/
		
		addStudent(  new Student("소연", "010-1111-1111") );		
	}

	private static void addStudent( Student stud ) {
		Connection   conn  =  null;
		Statement    stmt  =  null;		
		
		try {
			Class.forName(driver);
			conn        = DriverManager.getConnection(url,dbuid, dbpwd);
			stmt        = conn.createStatement();
			String sql  = "INSERT INTO student (  stnum, stname, tel) ";
			sql        += " VALUES ( SEQ_STNUM.nextval, '" 
			           + stud.getStname() + "', '" 
					   + stud.getTel()    + "')"; 			
			System.out.println("sql1:" + sql);
			  
			int aftcnt  = stmt.executeUpdate(sql);
			System.out.println(aftcnt + "건 추가되었습니다");
			
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null )  stmt.close();
				if(conn != null )  conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		
	}

	private static void addStudent(String name, String tel) {
		Connection   conn  =  null;
		Statement    stmt  =  null;		
		
		try {
			Class.forName(driver);
			conn        = DriverManager.getConnection(url,dbuid, dbpwd);
			stmt        = conn.createStatement();
			String sql  = "INSERT INTO student (  stnum, stname, tel) ";
			sql        += " VALUES ( SEQ_STNUM.nextval, '" + name + "', '" + tel + "')"; 			
			System.out.println("sql1:" + sql);
			  
			int aftcnt  = stmt.executeUpdate(sql);
			System.out.println(aftcnt + "건 추가되었습니다");
			
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null )  stmt.close();
				if(conn != null )  conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		
	}

}
