package ex03;

public class TestMain {
	//가변인자 : 파라미터의 갯수가 유동적
	
	
	/*
	public static double add(double a1, double a2, double a3) {
		double sum = 0.0;
		sum = a1 + a2+a3;
		return sum;
	}
	
	public static int add(int a1, int a2, int a3) {
		int sum = 0;
		sum = a1 + a2+a3;
		return sum;
	}
	
	*/
	
	public static double add(double ... v) {
		double sum = 0.0;
		for(int i =0; i<v.length; i++) {
			sum +=v[i];
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		double r1 = add(1.0,2.0,3.0);
		System.out.println(r1);
		double r2 = add(1.0,2.0);
		System.out.println(r2);

		//		double n1 = TestMain.add(1.0, 2.0, 3.0);
//		System.out.println(n1);
//		int n2 = add(2,3,4);
//		System.out.println(n2);
//		int n3 = add(5,7);
		
	}
}
