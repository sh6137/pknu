package ex01;

public class Test02 {
	
	static int add(int v1,int v2){
		int v;
		v = v1 + v2;
		return v;
	}
	
	static int sub(int v1, int v2) {
		int v;
		v = v1 -v2;
		return v;
	}
	
	public static void main(String[] args) {
		int a =7,b=2;
		int c=1;
		
		c=Test02.add(a,b);
		System.out.println(c);
		
		c=Test02.sub(a, b);
		System.out.println(c);
		
	}
}
