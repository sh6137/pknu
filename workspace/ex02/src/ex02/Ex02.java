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
		//예외처리(try catch)
		try {
			c1=7; c2=0;
			int r11 = c1/c2;
			System.out.println(r11);
		} catch (ArithmeticException e) {
			System.out.println("계산 error" + e.getMessage());
		} catch (Exception e) {
			System.out.println("error");
		}
		System.out.println("end");
		
		int age = 27;
		boolean adult = age >19;
		System.out.println(adult);
		
		System.out.println("End");
		System.out.println();
		System.out.println();
		
		/*
		 * 
		 * 비교 논리 연산
		 * 
		 */
		int num1 = 1;
		String name1 = "아이유";
		int age1 = 25;
		String address1 = "부산";
		String address2 = "부산";
		char gender1 = '여';
		
		//20대 
		boolean bl1= gender1 == '여';
		System.out.println("b1");
		System.out.println(bl1);
		
		//20대 여자
		boolean bl2= gender1 == '여' && (age1 >=20 && age1 < 30);
		System.out.println("b2");
		System.out.println(bl2);
		
		//20대 부산 여자
		boolean bl3= gender1 == '여'&& (age1 >=20 && age1 < 30) && address1.equals("부산");
		System.out.println("b3");
		System.out.println(bl3);	
		//20대 부산 여자 대구, 창원
		boolean bl4= gender1 == '여'&& (age1 >=20 && age1 < 30) && address1.equals("부산") || address1.equals("대구") || address1.equals("창원");
		System.out.println("b4");
		System.out.println(bl4);	
		
		boolean bl5 = address1 == address2;
		System.out.println(bl5);
		}
}
