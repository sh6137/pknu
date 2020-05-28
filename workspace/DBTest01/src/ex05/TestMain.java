package ex05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestMain {

	private static String driver = "oracle.jdbc.OracleDriver";
	//private static String url    = "jdbc:oracle:thin:@210.179.12.120:1521:xe";
	private static String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static String dbuid  = "hrd202";
	private static String dbpwd  = "1234";
	
	public static void main(String[] args) {
		
		ArrayList<StudentScore>  list = getStudentScoreList();
		
		for (StudentScore studentScore : list) {
			System.out.println( studentScore.info() );
		}
	}

	private static ArrayList<StudentScore> getStudentScoreList() {
		
		ArrayList<StudentScore> slist = new ArrayList<StudentScore>();
		Connection  conn = null;
		Statement   stmt = null;
		ResultSet   rs   = null;
		
		try {
			Class.forName(driver);
			conn        =  DriverManager.getConnection(url, dbuid, dbpwd);
			stmt        =  conn.createStatement();
			String  sql = "SELECT    ST.stnum,   ST.stname,";
			sql        += " DECODE(sum(SC.score), NULL, '미응시', SUM(SC.SCORE)) TOTSCORE,";
			sql        += " DECODE(AVG(SC.SCORE), NULL, '미응시', ";
			sql        += " TO_CHAR(avg(SC.score), '999,999')) AVGSCORE,";
			sql        += "  case "; 
			sql        += "  when AVG(SC.SCORE) >= 90 then 'A' ";
			sql        += "  when AVG(SC.SCORE) >= 80 then 'B' ";
			sql        += "  when AVG(SC.SCORE) >= 70 then 'C' ";
			sql        += "  when AVG(SC.SCORE) >= 60 then 'D' ";
			sql        += "  else                        'F'   ";
			sql        += "  end  GRADE, ";
			sql        += "  RANK() OVER (ORDER BY AVG(SC.SCORE) DESC NULLS LAST) ";
			sql        += "  RNK ";
			sql        += "  FROM    student ST LEFT JOIN  SCORES SC ";
			sql        += "  ON ST.STNUM = SC.STNUM ";
			sql        += "  GROUP BY   ST.stnum,   ST.stname ";
  			
			rs          =  stmt.executeQuery(sql);
						
			while( rs.next() ) {
				int     stnum     =  rs.getInt("stnum");
				String  stname    =  rs.getString("stname");
				String  totscore  =  rs.getString("totscore");
				String  avgscore  =  rs.getString("avgscore");
				String  grade     =  rs.getString("grade");
				int     rank      =  rs.getInt("rnk");
				
				StudentScore  sc = new StudentScore(
					stnum, stname, totscore, avgscore, grade, rank);
				
				slist.add( sc ); 
						
			}			
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("오류:" + e.getMessage() );
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
