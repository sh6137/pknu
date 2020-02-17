package ex03;

public class Test01 {
	//getter setter 를 통한 외부데이터 입 출력
	public static void main(String[] args) {
		int v;
		Sachic s1 = new Sachic();
		
		s1.setV1(7);
		s1.setV2(2);
		
		v = s1.add();
		System.out.println(v);
		
		v = s1.mul();
		System.out.println(v);
		
		
	}
}
