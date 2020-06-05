package callabelstatement1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

// Data Access Object
public class MemberDao {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private String dbuid  = "jdbctest";
	private String dbpwd  = "1234";
	
	private Connection         conn;
	private CallableStatement  cstmt;
	private ResultSet          rs;
	
	public MemberDao() {
		open();
	}

	private void open() {
		try {
			Class.forName(driver);
			conn  = DriverManager.getConnection(url, dbuid, dbpwd); 
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(rs    != null)  rs.close();
			if(cstmt != null)  cstmt.close();
			if(conn  != null)  conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 추가 : MEMID, MNAME, EMAIL, PASSWD, PHON
	public 	int addMember(MemberVO vo) {
		int insertCnt = 0;
		try {
			String  sql = "{call SPADDMEMBER( ?,?,?,?,? ) }";	
			cstmt       =  conn.prepareCall(sql);
			;
			cstmt.setString(1,  vo.getMemid() );
			cstmt.setString(2,  vo.getMname() );
			cstmt.setString(3,  vo.getEmail() );
			cstmt.setString(4,  vo.getPasswd() );
			cstmt.setString(5,  vo.getPhone() );
			insertCnt   = cstmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		
		return  insertCnt;
	}

	public MemberVO getMember(String memid) {
		MemberVO   mem  = null;
		
		try {
			String sql  = "{call  SPGETMEMBER( ?,?,?,?,?,?,?,?,? )}";
			cstmt   =   conn.prepareCall(sql);
			// 파라미터 setting			
			cstmt.setString(1, memid);
			
			// out 파라미터에만 지정한다
			cstmt.registerOutParameter(2, Types.VARCHAR );
			cstmt.registerOutParameter(3, Types.VARCHAR );
			cstmt.registerOutParameter(4, Types.VARCHAR );
			cstmt.registerOutParameter(5, Types.VARCHAR );
			cstmt.registerOutParameter(6, Types.VARCHAR );
			cstmt.registerOutParameter(7, Types.VARCHAR );
			cstmt.registerOutParameter(8, Types.NUMERIC ); //POINT
			cstmt.registerOutParameter(9, Types.VARCHAR ); //MLEVEL
			// VARCHAR2  => Types.VARCHAR (ANSI)
			// NUMBER    => Types.NUMERIC (ANSI)
			
			cstmt.executeQuery();
			
			// 조회된 결과 처리
			String out_memid    = cstmt.getString( 2 );
			if(out_memid.equals("NODATA") || out_memid.equals("ERROR:" )) { //자료없음
				System.out.println("문제발생:" + out_memid);
				return null;
			}
			String out_mname    = cstmt.getString( 3 );
			String out_email    = cstmt.getString( 4 );
			String out_passwd   = cstmt.getString( 5 );
			String out_phone    = cstmt.getString( 6 );
			String out_regdate  = cstmt.getString( 7 );
			int    out_mpoint   = cstmt.getInt( 8 );    // mpoint
			String out_mlevel   = cstmt.getString( 9 ); // mlevel
			
			mem = new MemberVO(out_memid, out_mname, out_email, out_passwd,
					out_phone,	out_regdate, out_mpoint, out_mlevel);  
						
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return  mem;
	}

	@SuppressWarnings("restriction")
	public List<MemberVO> getMemberList() {
		List<MemberVO>  list = new ArrayList<MemberVO>();
		
		try {
			String sql  = "{call  SPGETMEMBERLIST(?) }";
			cstmt  =  conn.prepareCall(sql);
			// 파라미터 설정
			cstmt.registerOutParameter(1, 
				oracle.jdbc.internal.OracleTypes.CURSOR	); 
			  // 낮은버전 
			  // configure problem sevility 표시되면 
			//  화살표표시된 Error _. Warning 으로 변경 한다 
			//cstmt.registerOutParameter(1, Types.REF_CURSOR ); 
			  // java8, ojdbc7.jar 문법
			  // redhat java8 + ojdbc6.jar 에서 에러발생 
			  //  java.sql.SQLException: 부적합한 열 유형: 2012
			
			// 프로시저 실행
			cstmt.executeQuery();
			
			// 조회된결과처리
			ResultSet rs = (ResultSet) cstmt.getObject(1);
			while(rs.next() ) {
				String memid    = rs.getString("memid");
				String mname    = rs.getString("mname");
				String email    = rs.getString("email");
				String phone    = rs.getString("phone");
				String regdate  = rs.getString("regdate");
				String mlevel   = rs.getString("mlevel");
				MemberVO m  = new MemberVO(memid, mname, email, 
						phone,regdate, mlevel);
				list.add( m );
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}   	
		
		return list;  // ㅈ회한 자료가 없으면 list.size()
	}

	public int delMember(String memid) {
		int delCnt = 0;
		try {
			String sql = "{call SPDELMEMBER(?,?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, memid);
			cstmt.registerOutParameter(2, Types.NUMERIC);
			
			cstmt.executeUpdate();
			
			delCnt = cstmt.getInt(2);
			System.out.println("삭제건수 : delCnt");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return delCnt;
	}
	
	
	
	
	
	
	
}
