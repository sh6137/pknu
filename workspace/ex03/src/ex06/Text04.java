package ex06;

import java.util.Scanner;

public class Text04 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = "";
		
		String input[] = new String[5];
		String []name = new String[5];
		
		String []mathStr = new String[5];
		String []korStr = new String[5];
		String []engStr = new String[5];
		
		int []math = new int[5];
		int []eng = new int[5];
		int []kor = new int[5];
		int []total = new int[5];
		int []avg = new int[5];
		
		for (int i = 0; i < input.length; i++) {
			System.out.println(i+" : 이름,국어,영어,수학  :(,입력)");
			input[i] = in.nextLine();
			System.out.println();
			str = input[i];
			int num = 0;
			String[] val= str.split(",");
			name[i] = val[num];
			korStr[i] = val[num+1];
			engStr[i] = val[num+2];
			mathStr[i] = val[num+3];
			
			kor[i] = Integer.valueOf(korStr[i]);
			math[i] = Integer.valueOf(mathStr[i]);
			eng[i] = Integer.valueOf(engStr[i]);
		}
		
		for (int i = 0; i < name.length; i++) {
			total[i] = kor[i]+eng[i]+math[i];
			avg[i] = total[i]/3;
		}
		
		for (int i = 0; i < name.length; i++) {
			System.out.println(i+"이름 : "+ name[i] + " 국어 : "+kor[i]+" 영어 : "+eng[i]+" 수학 : "+math[i] +
								"|총점 : " + total[i] + " 평균 : " + avg[i] );
		}
		
		
		
		
	}
}
