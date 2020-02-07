package ex01;

import java.util.Date;

public class Ex03 {
	public static void main(String[] args) {
		Date today = new Date();
		short num1 = 0;

		int num2 = 0;
		int age = 26;
		float height = 178.3f;
		float height2 = (float) 180.3;
		double height3 = 178.3;

		boolean adult = true;
		@SuppressWarnings("deprecation")
		int year = today.getDate();
		num1 = 32767;
		num2 = 2121;

		System.out.println(num1);
		num1 = (short) (num1 + (short) 3);
		System.out.println(num1);

		if (0 ==0.0) {
			adult = true;
		}
		height3 = height3+3;
		
		System.out.println(today);
		System.out.println(year);
	}
}
