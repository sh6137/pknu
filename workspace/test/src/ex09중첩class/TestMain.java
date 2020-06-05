package ex09중첩class;

//중첩클래스 : nested class
//Outer class(inner class)
class Test{ //Outer class
	static int a = 10;
	int b = 20;
	
	void write() {
		final int c = 30;
		int d = 40; // final 필요
		
		class LocalTest{
			void write() {
				System.out.println("a : " + a);
				System.out.println("b : " + b);
				System.out.println("c : " + c);
				
				//값을 변경 : final은 변경안됨
				//c =12;
				
				int innerC = c;
				
				innerC +=30; //사용가능
				
				int innerD = d;
				innerD +=40;
				//d = 100;  : final 붙이지 않아 error
				System.out.println("d : " + d);
				
				System.out.println(innerC);
				System.out.println(innerD);
			} //inner write end
		} //class LocalTest end
		
		LocalTest lt = new LocalTest();
		lt.write();
	}	//outer write end
}

public class TestMain {
	public static void main(String[] args) {
		Test te = new Test();
		te.write();
		
	}
}
