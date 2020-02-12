package ex03;

import java.util.Scanner;

public class Tx {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int age = 0;
		String adult;
		String tti;
		int thisyear=2020;
		System.out.println("나이를 입력");
		age = age();
		System.out.println(age);
		adult = process(age);
		System.out.println(adult);
		tti = ttiprocess(age , thisyear);
		System.out.println(tti);
		
	}

	private static String ttiprocess(int age ,int thisyear) {
		int birthyear=0;
		String tti = null;
		birthyear = thisyear - age +1;
		
		if((int)((double)birthyear%12 +0.5) == 1) {
			tti = "닭";
		}
		if((int)((double)birthyear%12 +0.5) == 2) {
			tti = "개";
		}
		if((int)((double)birthyear%12 +0.5) == 3) {
			tti = "돼지";
		}
		if((int)((double)birthyear%12 +0.5) == 4) {
			tti = "쥐";
		}
		if((int)((double)birthyear%12 +0.5) == 5) {
			tti = "소";
		}
		if((int)((double)birthyear%12 +0.5) == 6) {
			tti = "호랑이";
		}
		if((int)((double)birthyear%12 +0.5) == 7) {
			tti = "토끼";
		}
		if((int)((double)birthyear%12 +0.5) == 8) {
			tti = "용";
		}
		if((int)((double)birthyear%12 +0.5) == 9) {
			tti = "뱀";
		}
		if((int)((double)birthyear%12 +0.5) == 10) {
			tti = "말";
		}
		if((int)((double)birthyear%12 +0.5) == 11) {
			tti = "양";
		}
		if((int)((double)birthyear%12 +0.5) == 12) {
			tti = "원숭이";
		}
		

		
		return tti;
	}

	private static String process(int age) {
		String adult = null;
		if(age > 19) {
			adult = "성인";
		}
		else {
			adult = "미성년";
		}
		return adult;
	}

	private static int age() {
		int age =0;
		Scanner in =  new Scanner(System.in);
		age = in.nextInt();
		return age;
	}
	
}
