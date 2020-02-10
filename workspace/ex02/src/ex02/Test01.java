package ex02;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in); 
		
		int [ ]b = new int[4];
		int a;
		int tmp;
		int num;
		String name;
		int age;
		int kor;
		int math;
		int eng;
		int score;
		int total;
		int birthday;
		char grade;
		int thisyear = 2020;
		
//		b[0] = 19911012%10000000;
//		System.out.println(b[0]);
		
		System.out.println("번호");
		num = Integer.parseInt(in.nextLine());
		System.out.println("이름을 입력");
		name = in.nextLine();
		
		System.out.println("생일 : (8자리 : 19911012)");
		birthday = Integer.parseInt(in.nextLine());

		b[0] = birthday/10000000;
		tmp  = birthday%10000000;
		b[1] = tmp	  /1000000;
		tmp  = tmp	  %1000000;
		b[2] = tmp	  /100000;
		tmp  = tmp	  %100000;
		b[3] = tmp	  /10000;
		tmp  = tmp	  %10000;
		
		a = (b[0]*1000 + b[1]*100 + b[2]*10 + b[3]*1);
		age = (thisyear - a +(int)1); 
		System.out.println("나이는 : ");
		System.out.println(age);
		
		System.out.println("국어점수 입력 : ");
		kor = Integer.parseInt(in.nextLine());
		
		System.out.println("영어점수 입력 : ");
		eng = Integer.parseInt(in.nextLine());
		
		System.out.println("수학점수 입력 : ");
		math = Integer.parseInt(in.nextLine());
		
		total = kor + eng + math;
		score = (kor + eng + math)/3;
		
		
		if(score >= 90 && score <=100) {
			grade = 'A';
		}
		else if(score >= 80 && score < 90) {
			grade = 'B';
		}
		else if(score >= 70 && score < 80) {
			grade = 'C';
		}
		else if(score >= 60 && score < 70) {
			grade = 'D';
		}
		else {
			grade = 'F';
		}
		
		System.out.println(name + "님의 번호는 " + num + " 생일은 "+ birthday + "나이는" + age
							 +" 평균은 "+ score +" 등급은 : " + grade +"입니다." );
		
		
		
	}
}
