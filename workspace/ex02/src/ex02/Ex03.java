package ex02;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		//키보드로 data를 입력 받는다.
		
		//입력받을 준비
		Scanner in  = new Scanner(System.in);
		/*
		 * stdin : keybord
		 * stdout: monitor
		 * stderr: monitor
		 * stdprn:printer
		 */
		
		String name;
		int age;
		int score;
		String result = "";
		//60 점 이상이면 pass 아니면 fail
		
		System.out.println("이름 : ");
		name = in.nextLine();
		System.out.println("나이 : ");
		age = Integer.parseInt(in.nextLine());
		System.out.println("점수 : ");
		score = Integer.parseInt(in.nextLine());
		
		if(score >= 60)
			result = "pass";
		else
			result = "fail";
		
		System.out.println("당신의 이름은 : " + name);
		System.out.println("당신의 나이는 : " + (age+1));
		System.out.println(result);
	}
}
