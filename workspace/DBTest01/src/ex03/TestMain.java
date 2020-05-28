package ex03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
<<<<<<< HEAD

import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

public class TestMain {
   
      private static String driver = "oracle.jdbc.OracleDriver";
      private static String url    = "jdbc:oracle:thin:@localhost:1521:orcl";
      private static String dbuid  = "testdb2";
      private static String dbpwd  = "1234";

   public static void main(String[] args) {
      
   getData();

   }

   private static void getData() {
      Connection conn = null;
      Statement  stmt = null;
      ResultSet  rs   = null;
      
      try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url,dbuid,dbpwd);
         stmt = conn.createStatement();
         String sql  = "SELECT STNUM, STNAME, TEL, ";
               sql += " TO_CHAR(INDATE, 'YYYY-MM-DD DAY') INDATE";
               sql += " FROM STUDENT";  
         rs          = stmt.executeQuery(sql);
         while(rs.next()) {
            int  stnum    = rs.getInt("stnum");
            String stname = rs.getString("stname");
            String tel    = rs.getString("tel");
            /*Date indate = rs.getDate("indate");*/
            String indate = rs.getString("indate");
            String pattern = "{0} {1} {2} {3}";
            
            String msg = MessageFormat.format(pattern, stnum, stname, tel, indate);
            System.out.println(msg);
         }
      } catch (ClassNotFoundException e) {
         System.out.println("no driver");
       } catch(SQLException e) {
         System.out.println("오류 :" + e.getMessage());
      } finally {
         try {
            if(rs != null)
            rs.close();
            if(rs != stmt)
            stmt.close();
            if(conn != null)
             conn.close();
         }catch(SQLException e) {
            
         }
      
      }
      
   }

}
=======
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;

public class TestMain {

	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static String dbuid  = "hrd202";
	private static String dbpwd  = "1234";
	
	public static void main(String[] args) {
		
		ArrayList<String> list = getData();
		
		for (String student : list) {
			System.out.println(student);
		}
		
	}

	private static ArrayList<String> getData()  {
		
		ArrayList<String> slist =  new ArrayList(); 
		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			Class.forName(driver);
			conn        =  DriverManager.getConnection(url, dbuid, dbpwd);
			stmt        =  conn.createStatement();
			String sql  = "select stnum, stname, tel, ";
			sql        += " TO_CHAR(indate, 'YYYY-MM-DD DAY') indate ";
			sql        += " from  student ";			
			rs          = stmt.executeQuery(sql);
			while( rs.next() ) {
				int      stnum   =  rs.getInt("stnum");
				String   stname  =  rs.getString("stname");
				String   tel     =  rs.getString("tel");
				//Date     indate  =  rs.getDate("indate");
				String   indate   =  rs.getString("indate");
				String   pattern  = "{0}  {1}   {2}    {3}"; 
				String   msg      = MessageFormat.format(pattern, 
					stnum, stname, tel, indate	);
				
				slist.add( msg );
				//System.out.println(msg);
			}		
			
		} catch (ClassNotFoundException e) {			
			System.out.println("드라이버가 없습니다");
		} catch (SQLException e) {
			System.out.println( "오류:" + e.getMessage()  );
		} finally {
			try {
				if(rs   != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {				
			}
		}
		
		return slist;
	}
	
	

}
>>>>>>> 41c882846d9359085f78a3d8cad0e677e64ea61c
