package preparedstatement1;

import java.util.List;

public class TestMain {
	
	private static DBHandler db;
	
	public static void main(String[] args) {
		db = new DBHandler();
		
		displayMemberList();
		
		//추가
		Member insertM = new Member("아름","ar@naver.com","010-2345-6789");
		int cnt = db.addMember(insertM);
		System.out.println(cnt + "건 추가");
		
		//수정 : 이름, 이메일, 전화, 포인트
		Member updateM = new Member(5,"석준","sj@naver.com","010-7895-4652",1000);
		int updateCnt = db.updateMember(updateM);
		System.out.println(updateCnt + " : 건 수정");
		//삭제
		Member deleteM = new Member(7);
		int deleteCnt = db.deleteMember( deleteM );
		
		//개인조회  : 12번 조회
		
		Member selectedM = new Member(12);
		
		
		//목록 출력
		displayMemberList();
		
		
		db.close();
	}

	private static void displayMemberList() {
		// 목록조회
		List<Member> mlist = db.getMemberList();
		System.out.println("=================목록=================");
		for (Member member : mlist) {
			System.out.println(member.listInfo());
		}
		
	}
}
