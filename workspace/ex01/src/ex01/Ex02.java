package ex01;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int thisyear = 2020;
		int birthyear = 2016;
		int age = 0;
		String a= "";
		String b = "";
		String name = "홍길동";
		age = thisyear - birthyear + 1;
		
		if(age >= 19) {
			b = "성인임";
		}
		else{
			b="미성년자임";
		}
		
		System.out.println("나이는 : " + age);
		System.out.println(b);
		System.out.println("서두르듯 마지막 말할까봐");
		System.out.println("다음 가사는");
		a = in.nextLine();
		System.out.println();
		System.out.println(a);
	}
}
