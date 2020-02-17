package ex05;

public class Test01 {
	public static void main(String[] args) {
		Sachic s = new Sachic();
		
		int v = s.add(7,2);
		System.out.println(v);
		
		//s.v1 = 123;
		//s.v2 = 200;
		s.setV1(70);
		s.setV2(3);
		
		v=s.add();
		System.out.println(v);
		int v1 = s.getV1();
		System.out.println(v1);
		
		Sachic s2 = new Sachic(120,4);
		s2.sub();
	}
}
