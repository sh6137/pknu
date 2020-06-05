package ex02;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		//다중선택
		/*
		 * Vip : 포인트가 10000 이상
		 * 정회원 : 5000
		 * 준회원 : 1000
		 */
		Scanner in = new Scanner(System.in);
		
		String name = "";
		int point = 0;
		String grade = "";
		
		System.out.println("이름을 입력하세요");
		name = in.nextLine();
		System.out.println("포인트 입력");
		point = Integer.parseInt(in.nextLine());
		
		if(point >= 10000) {
			grade = "Vip";
		}
		else if(point >= 5000) {
			grade = "정회원";
		}
		else if(point >=1000) {
			grade = "준회원";
		}
		else {
			grade = "일반회원";
		}
		System.out.println(name + "님의 등급은 : " + grade);
		
	}
}
