package ex04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestMaiin {

	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static String dbuid  = "hrd202";
	private static String dbpwd  = "1234";
	
	public static void main(String[] args) {
		ArrayList<Student> list =  getData();
		for (Student student : list) {
			System.out.println( student );
		}
	}

	private static ArrayList<Student> getData() {
		
		ArrayList<Student> slist = new ArrayList<>();
		
		Connection  conn = null;
		Statement   stmt = null;
		ResultSet   rs   = null;
		try {
			Class.forName(driver);
			conn        =  DriverManager.getConnection(url, dbuid, dbpwd);
			stmt        =  conn.createStatement();
			String  sql = "SELECT STNUM, STNAME, TEL, ";
			sql        += " to_char(indate, 'YYYY-MM-DD DY') indate ";
			sql        += " FROM  STUDENT ";
			rs          = stmt.executeQuery(sql);
			while( rs.next() ) {
				int     stnum   = rs.getInt("stnum");
				String  stname  = rs.getString("stname");  
				String  tel     = rs.getString("tel");  
				String  indate  = rs.getString("indate");
				
				Student s       = new Student(stnum, stname, tel, indate);
				slist.add(s);
			}
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				if(rs   != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
		}
		
		return slist;
	}

}
