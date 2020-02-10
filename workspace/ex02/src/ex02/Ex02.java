package ex02;

public class Ex02 {
	public static void main(String[] args) {
		//이항 연산자
		int a1 = 3, a2 = 4;
		int r1 = a1*a2;
		System.out.println(r1);
		
		//단항 연산자 : 증감연산자
		int b1 = 3;
		int r2 = b1++;
		//int r2 = ++b1;
		System.out.println("b1=" + b1 + "   b1++= " + r2 );
		
//		사칙연산
		int r4 = 3+4*12;
		int r5 = 3+7/2;
		System.out.println(r4 + "  " +r5);
		
		float aa = 2.f;
		double r6 = 3+7.0/2.0;
		System.out.println(r6);
		
		//(double) 캐스팅 연산자, 강제형변환
		int c1=7, c2=2;
		double r8 =3.0 + (double) c1/ (double)c2;
		System.out.println(r8);
		
		int r9 = c1/c2;
		System.out.println(r9);
		
		c1=0; c2 = 2;
		int r10 = c1/c2;
		System.out.println(r10);
		
		//divide by zero - 예외 : 실행할때 발생하는 오류
		c1=7; c2=0;
		int r11 = c1/c2;
		System.out.println(r11);
		
	}
}
