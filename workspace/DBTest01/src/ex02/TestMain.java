package ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMain {

	private static String  driver = "oracle.jdbc.OracleDriver";
	private static String  url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String  dbuid  = "hr";
	private static String  dbpwd  = "1234";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection  conn =  DriverManager.getConnection(url, dbuid, dbpwd);
		Statement   stmt =  conn.createStatement();
		String      sql  =  "SELECT   D.DEPARTMENT_NAME  DNAME, "; 
		sql             += 	"   TO_CHAR(nvl(AVG(E.SALARY),0), '$99,990.999' ) AVGSAL"; 
		sql             +=	"   FROM   DEPARTMENTS D, EMPLOYEES E "; 
		sql             +=	" WHERE     D.DEPARTMENT_ID = E.DEPARTMENT_ID(+) "; 
		sql             +=  " GROUP BY  D.DEPARTMENT_NAME "; 
		sql           	+= 	" ORDER BY  D.DEPARTMENT_NAME ";
		
		System.out.println("sql1:" + sql);
		
		ResultSet   rs   =  stmt.executeQuery( sql );   
		
		while( rs.next()  ) {
			String  dname  =  rs.getString("dname");
			String  avgsal =  rs.getString("avgsal");
			String  fmt    =  "%-20s  %10s";
			String  msg    =  String.format(fmt, dname, avgsal);
			System.out.println(msg);
		}				
		
		rs.close();
		stmt.close();
		conn.close();

	}

}
