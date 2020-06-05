package ex02;

//Nested Class : 중첩클래스
class Test{
	static int a = 10;
	int n ,b  = 20;
	
	void write() {
		final int c =30;
		int d = 40;
		
		//Inner Class
		class LocalTest{
			void write() {
				System.out.println("a : "+a);
				System.out.println("b : "+b);
				System.out.println("c : "+c);
				System.out.println("d : "+d);	
			}
		}
		LocalTest ob = new LocalTest();
		ob.write();
	}
}

public class TestMain {
	public static void main(String[] args) {
		
	}
}
