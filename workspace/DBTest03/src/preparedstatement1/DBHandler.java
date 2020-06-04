package preparedstatement1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String dbuid = "testdb2";
	private String dbpwd = "1234";
	
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	
	public DBHandler() {
		open();
	}
	
	public Connection open() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,dbuid,dbpwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public List<Member> getMemberList() {
		List<Member> mlist = new ArrayList<Member>();

		try {
			String sql = "SELECT M.MID, M.NAME, M.EMAIL, ML.MLEVEL " + 
					"FROM MEMBER M " + 
					"JOIN MEMBERLEVEL ML " + 
					"ON M.POINT BETWEEN ML.LOPOINT AND ML.HIPOINT"
					+ " ORDER BY M.MID ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			while(rs.next()) {
				int mid = rs.getInt("MID");
				String name = rs.getString("NAME");
				String email = rs.getString("EMAIL");
				String mlevel = rs.getString("MLEVEL");
				Member m  = new Member(mid, name,email,mlevel);
				mlist.add(m);
				m.toString();
				System.out.println(m.toString());
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mlist;
	}
	
	
	
	public void close() {
		try {
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int addMember(Member insertM) {
		int cnt = 0;
		
		
		try {
			String sql ="INSERT INTO MEMBER( MID ,NAME, EMAIL, PHONE) " + 
					"VALUES( (SELECT NVL(MAX(MID),0)+1 FROM MEMBER),"
					+ "?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "원석"); //setString이  자동으로 작은 따옴표를 추가해줌
//			pstmt.setString(2, "ys@naver.com");
//			pstmt.setString(3, "010-5555-7894");
			pstmt.setString(1, insertM.getName());
			pstmt.setString(2, insertM.getEmail());
			pstmt.setString(3, insertM.getPhone());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	//수정 5,"석준","sj@naver.com","010-7895-4652",1000
	public int updateMember(Member updateM) {
		int updateCnt = 0;
		
		try {
			String sql = "UPDATE MEMBER " + 
					"SET NAME= ?, "
					+ "EMAIL = ?, "
					+ "PHONE = ?, "
					+ "POINT =  ? " + 
					"WHERE MID =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updateM.getName());
			pstmt.setString(2, updateM.getEmail());
			pstmt.setString(3, updateM.getPhone());
			pstmt.setInt(4, updateM.getPoint());
			pstmt.setInt(5, updateM.getMid());
			updateCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return updateCnt;
	}

	public int deleteMember(Member deleteM) {
		int deleteCnt = 0;
		try {
			String sql = "DELETE FROM MEMBER WHERE MID =?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deleteM.getMid());
			deleteCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return deleteCnt;
	}

	
	
}
