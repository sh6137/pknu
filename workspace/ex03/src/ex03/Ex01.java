package ex03;

import java.util.Scanner;

public class Ex01 {
	static String name;
	static int kor, eng, mat;
	static int tot;
	static int avg;
	
	public static void main(String[] args) {
		
		
		input();
		process();
		output();
		
		avg=round(tot/3.0);
		
		
	}

	private static void output() {
		
		System.out.println("이름 : " + name + "  총점 : " + tot);
		System.out.println("평균 : " + avg);
	}

	private static void process() {
		tot = kor+eng+mat;
		//avg =(int)((double)tot/3.0+0.5);
		avg = round(tot/3.0);
	}
	private static int round(double num) {
		int val=0;
		val= (int)(num+0.5);
		return val;
	}
	private static void input() {
		
		Scanner in = new Scanner(System.in);
//		name="wwww";
//		kor=100;
//		eng=90;
//		mat=80;
		System.out.println("이름 : ");
		name=in.next();
		System.out.println("국어 : ");
		kor=in.nextInt();
		System.out.println("영어 : ");
		eng=in.nextInt();
		System.out.println("수학 : ");
		mat=in.nextInt();
		
	}
}
