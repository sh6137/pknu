package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMain01 {

	// oracle 과 연결
	// driver 프로그램 필요 : ojdbc.jar )
	// C:\java8\jre\lib\ext\ojdbc.jar 파일 복사 한다
	
	private static String  driver = "oracle.jdbc.OracleDriver";
	private static String  url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String  dbuid  = "hr";
	private static String  dbpwd  = "1234"; 
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection  conn = DriverManager.getConnection(url, dbuid, dbpwd);
		Statement   stmt = conn.createStatement();
		
		//String     sql = "SELECT FIRST_NAME, LAST_NAME FROM EMPLOYEES";
		String     sql   = "SELECT   D.DEPARTMENT_NAME, ";
		sql             += " E.FIRST_NAME || ' ' || E.LAST_NAME AS NAME" ; 
		sql             += " FROM    EMPLOYEES  E, DEPARTMENTS D"; 
		sql             += " WHERE   E.DEPARTMENT_ID = D.DEPARTMENT_ID";

		System.out.println("sql1:" + sql);
		
		ResultSet  rs  = stmt.executeQuery(sql);
		System.out.println("부서번호     이름");
		System.out.println("==================");
		while( rs.next() ) {
			// rs.getInt(columnIndex)
			String  dname  = rs.getString("DEPARTMENT_NAME");
			//String  ename  = rs.getString("NAME");
			String  ename  = rs.getString(2);  // 1~
			//String  fname  = rs.getString("FIRST_NAME");
			//String  lname  = rs.getString("LAST_NAME");
						
			System.out.println(dname + ", "  + ename );
		}
				
		rs.close();
		stmt.close();
		conn.close();

	}

}
