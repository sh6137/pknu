package ex01;

class Sachic2{
	int add(int v1,int v2){
		int v;
		v = v1 + v2;
		return v;
	}
	
	int sub(int v1, int v2) {
		int v;
		v = v1 -v2;
		return v;
	}

	int mul(int v1, int v2) {
		int v;
		v = v1 *v2;
		return v;
	}

	int mol(int v1, int v2) {
		int v;
		v = v1 /v2;
		return v;
	}
}

public class Text04 {
	
	public static void main(String[] args) {
		int a = 7, b=2;
		int c;
		Sachic2 s1 = new Sachic2();
		
		c = s1.add(a,b);
		System.out.println(c);
	}
}
