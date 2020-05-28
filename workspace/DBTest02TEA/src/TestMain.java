import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		System.out.println("찍어라");
		DBHandler      db   = new DBHandler();
	
		// 추가
		Member    m2  = new Member( "소연", "sy@NAVER.COM", "010-7777-1111" );
		System.out.println(("1."));
		int cnt  =  db.addMember(  m2  );
		System.out.println(("2."));
		System.out.println(cnt + "건 추가되었습니다");
		System.out.println(("3."));
		
		
		
		// 목록조회
		System.out.println("=====================================================");
		List<Member>   list = db.getMemberList();		
		for (Member member : list) {
			System.out.println( member.listinfo() );
		}
		
		// 개인조회
		System.out.println("=====================================================");
		int           mid   = 7; 
		Member        m     = db.getMember( mid );
		if ( m == null ) 
			System.out.println( mid + "번 자료가 없습니다");
		System.out.println( m.info() );
		
		// 삭제
		int del_mid  = 1;
		cnt = db.delMember( del_mid );
		if(cnt == 0 ) 
			System.out.println("삭제 되지않았습니다");
		else
			System.out.println(cnt + "건이 삭제 되었습니다");
	
		// 목록조회
		System.out.println("=====================================================");
		List<Member>   list2 = db.getMemberList();		
		for (Member member : list2 ) {
			System.out.println( member.listinfo() );
		}
		
		// 수정	 : update_mid, name, email, phone, newpoint
		System.out.println("수정");
		int   update_mid =  8;
		Member um  = new Member( update_mid, "형호", "hy@naver.com", "010-9876-5432", 2000);  
		cnt        =  db.updateMember(  um   );
		if(cnt == 0) 
			System.out.println("수정되지 않았습니다");
		else
			System.out.println(update_mid + "번 자료가" + cnt + "건 수정되었습니다");
		
		// 목록조회
		System.out.println("=====================================================");
		List<Member>   list3 = db.getMemberList();		
		for (Member member : list3 ) {
			System.out.println( member.listinfo() );
		}
		
		db.close();
	}

}
