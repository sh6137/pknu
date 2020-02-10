package ex02;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in); 
		
		//서울 10, 부산 20,인천 30, 대전 40,  대구50, 광주60, 제주70 
		
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
		int sido;
		String address = null;
		
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
		
		
		System.out.println("지역입력 : ");
		System.out.println("서울 10, 부산 20,인천 30, 대전 40,  대구50, 광주60, 제주70 ");
		sido = Integer.parseInt(in.nextLine());
		
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
		
//		if(sido == 10) {
//			address = "서울";
//		}
//		else if(sido == 20) {
//			address = "부산";
//		}
//		else if(sido == 30) {
//			address = "인천";
//		}
//		else if(sido == 40) {
//			address = "대전";
//		}
//		else if(sido == 50) {
//			address = "대구";
//		}
//		else if(sido == 60) {
//			address = "광주";
//		}
//		else if(sido == 70) {
//			address = "제주";
//		}
		
		switch (sido) {
		case 10:
			address = "서울";
			break;
		case 20:
			address = "부산";
			break;
		case 30:
			address = "인천";
			break;
		case 40:
			address = "대전";
			break;
		case 50:
			address = "대구";
			break;
		case 60:
			address = "광주";
			break;
		case 70:
			address = "제주";
			break;
		default:
			break;
		}
		
		switch (score/10) {
		case 10:
			grade ='A';
			break;
		case 9:
			grade ='B';
			break;
		case 8:
			grade ='C';
			break;
		case 7:
			grade ='D';
			break;
		default:
			grade='F';
			break;
		}
		
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
		
		System.out.println("주소 : " + address);
		
	}
}
