package ex04;

public class Test01 {
	public static void main(String[] args) {
		Sachic s1 = new Sachic(7, 2);
		Sachic s1 = new Sachic();
		int v;
		v = s1.add();
		System.out.println(v);
		
		v = s1.sub();
		System.out.println(v);
		v = s1.mul();
		System.out.println(v);
		v = s1.div();
		System.out.println(v);
	}
}
