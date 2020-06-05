package ex02;

public class Test01 {
	public static void main(String[] args) {
		Sachic sa = new Sachic();
		
		int v1 =7, v2 =2;
		int v;
		
		
		v = sa.add(v1, v2);
		System.out.println(v);
		
		v=sa.div(v1, 0);
		System.out.println(v);
		
	}
}
