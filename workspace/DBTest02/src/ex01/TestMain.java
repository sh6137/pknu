package ex01;


import java.util.List;

public class TestMain {
	public static void main(String[] args) {
		DBHandler db = new DBHandler();
		
		//목록조회
		List<Member> list = db.getmemberList();
		
		for (Member member : list) {
			System.out.println(member.listinof());
		}
		//개인조회
		System.out.println("================");
		int mid = 6;
		
		Member m = db.getmember(mid);
		if(m == null) 
		System.out.println(mid + "조회된 자료가 없습니다.");
		System.out.println(m.info());
		
		//Member m = db.getMember(mid);
		
		//추가
//		Member m2 = new Member("주연","jy@naver.com","010-1234-1111");
//		int cnt = db.addMember(m2);	
//		System.out.println(cnt + "건 추가 되었습니다.");
		
		//수정
		int mid2 = 6;
		Member m2 = new Member("독일","pa@naver.com","010-5555-5555");
		db.updateMember(mid2 ,m2);
		
	
		//삭제
		
//		int delmid = 1;
//		int cnt = db.delMember(delmid);
//		if(cnt == 0)		
//		System.out.println("삭제 ㄴㄴ");
//		else
//		System.out.println(cnt + "건이 삭제되었습니다.");
//		
		
		//목록조회
		List<Member> list2 = db.getmemberList();
			for (Member member : list2) {
				System.out.println(member.listinof());
			}
		
		
		db.close();
	}

	
}
