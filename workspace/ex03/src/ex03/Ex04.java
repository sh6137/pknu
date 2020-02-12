package ex03;

import java.util.Scanner;

public class Ex04 {
	
	//부서번호를 입력받아 부서명 출력
	//10: 인사부 ,20:저재부, 30, 총무부 40: 기술부
//			서울		부산			대전		대구
	public static void main(String[] args) {
		
		Scanner in =new Scanner(System.in);
		int deptno;
		
		System.out.println("부서 번호를 입력");
		System.out.println("10: 인사부 ,20:저재부, 30, 총무부 40: 기술부");
		
		deptno = in.nextInt();
		
		String deptname;
		deptname = getDeptInfo(deptno);
		
		System.out.println(deptname);
	}

	private static String getDeptInfo(int deptno) {
		String dname = null;
		String daddr = null;
		switch (deptno) {
		case 10:
			dname ="인사부";
			daddr = "서울";
			break;
		case 20:
			dname ="자재부";
			daddr = "부산";
			break;
		case 30:
			dname ="총무부";
			daddr = "대전";
			break;
		case 40:
			dname ="기술부";
			daddr = "대구";
			break;

		default:
			break;
		}
		return dname + "," + daddr;
	}
}
