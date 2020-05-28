package ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMain {
	
	  private static String driver = "oracle.jdbc.OracleDriver";
	  private static String url    = "jdbc:oracle:thin:@localhost:1521:orcl";
	  private static String dbuid  = "hr";
	  private static String dbpwd  = "1234";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
	    Connection conn = DriverManager.getConnection(url, dbuid, dbpwd);
	    Statement  stmt = conn.createStatement();
	      
	    //String    sql = "SELECT FIRST_NAME, LAST_NAME FROM EMPLOYEES";
	    String    sql = "SELECT D.DEPARTMENT_NAME DNAME," + 
	    		" TO_CHAR(AVG(E.SALARY), '$99,999.999') AVFSAL" + 
	    		" FROM departments D, EMPLOYEES E" + 
	    		" WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID" + 
	    		" group by D.DEPARTMENT_NAME" + 
	    		" ORDER BY D.DEPARTMENT_NAME";
	      
	            System.out.println("sql1:" + sql);
	            
	      ResultSet rs  = stmt.executeQuery(sql);
	      while(rs.next()) {

		         String dname = rs.getString("DNAME");
		         String avgsal = rs.getString("avgsal");
		         String fmt = "%-20s %10s";
		         String msg = String.format(fmt, dname,avgsal);
		         
		         System.out.println(msg);
		      }
	}
}
