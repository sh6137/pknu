package callabelstatement1;

import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		String uid  = "sky7";
		
		MemberDao dao = new MemberDao();
		MemberVO  vo  = new MemberVO(
				uid, "재영", "ys@nate.com", "1234", "010-2222-8888"); 
		int  insertCnt = dao.addMember(  vo  );
		System.out.println(insertCnt + "건 추가 되었습니다");

		// 'sky1' 을 조회하기		
		MemberVO  selMem  = dao.getMember( "sky" ); 
		if(selMem ==null)
			System.out.println("자료없음");
		else
		System.out.println( selMem.info() );
		
		//삭제
		int aftcnt = dao.delMember("sky5");
		System.out.println(aftcnt + " 건 삭제");
		// 전체 조회 : cursor 사용
		List<MemberVO>  list = dao.getMemberList();
		for (MemberVO memberVO : list) {
			System.out.println( memberVO.listInfo() );
		} 
		
		
	}

}
