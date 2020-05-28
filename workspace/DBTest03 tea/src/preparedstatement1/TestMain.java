package preparedstatement1;

import java.util.List;

public class TestMain {

	private static DBHandler  db;
	
	public static void main(String[] args) {
		db = new DBHandler();
		
		displayMemberList();
		
		// 추가ㅣ
		Member   insertM =  new Member( "재혁", "jh@naver.com", "010-8888-8888" );
		int insertCnt = db.addMember( insertM );
		System.out.println(insertCnt + "건 추가되었습니다");
		
		// 수정 : 번호, 이름, 이메일, 전화, 포인트
		Member   updateM = new Member(7, "상두", "sd@naver.com", "010-3333-3333", 4200);
		int updateCnt = db.updateMember( updateM  );
		System.out.println(updateCnt + "건 수정 되었습니다");
				
		// 삭제
		Member   deleteM    = new Member( 10  );
		int      deleteCnt  = db.deleteMember( deleteM );
		System.out.println(deleteCnt + "건 삭제 되었습니다");

		// 목록 출력
		displayMemberList();
		
		// 개인조회 : 12 번을 조회
		int      memId       =  140;
		Member   selM        =   new  Member( memId );    
		Member   selectedM   =   db.getMember( selM );
		
		System.out.println("==============  조회된 Member ===================");
		if( selectedM != null   )
			System.out.println(  selectedM.info()   );
		else
			System.out.println( memId + "번 회원은 없습니다");
		
		
		db.close();
	}

	//  목록 조회
	private static void displayMemberList() {
		List<Member> mlist = db.getMemberList();
		System.out.println("==================  회원목록   ====================");
		for (Member member : mlist) {
			System.out.println( member.listInfo()  );
		}		
	}

}
