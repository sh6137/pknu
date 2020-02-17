package ex01;

class Sachic{
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
}

public class Test03 {
	public static void main(String[] args) {
		int a =7,b=2;
		int c=1;
		
		Sachic aa= new Sachic();
		
		c=aa.add(a,b);
		System.out.println(c);
		
		
		
	}
}
