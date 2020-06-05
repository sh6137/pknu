package ex06;

public class Test02 {
	public static void main(String[] args) {
		//문자열 찾기
		String s1 ="이순신";
		System.out.println(s1.contains("순신"));
		System.out.println("순신");
		
		int pos1 = s1.indexOf("순신"); //문자열의 위치
		if(pos1 < 0)
			System.out.println("문자열을 못찾았다.");
		else
			System.out.println("순신의 위치 : " + pos1);
		String s2 = "Java 언어, Java 웹, java 싫어";
		int pos2 = s2.indexOf("Java");
		System.out.println(pos2);
		
		int pos3 = s2.indexOf("Java",pos2+1);
		System.out.println(pos3);
		
		System.out.println("===================");
		int pos4 = s2.lastIndexOf("Java");
		System.out.println(pos4);
		int pos5 = s2.lastIndexOf("Java", pos4-1);
		System.out.println(pos5);
		
		
		System.out.println(s2.toLowerCase());
		int pos6_1 = s2.toLowerCase().indexOf("java");
		System.out.println(pos6_1);
		System.out.println(s2.toLowerCase());
		int pos6_2 = s2.toLowerCase().indexOf("java");
		System.out.println(pos6_2);
		System.out.println(s2.toLowerCase());
		int pos6_3 = s2.toLowerCase().indexOf("java");
		System.out.println(pos6_3);
		
		//문자열 비어있는지 검사
		
		String sa1 = "abcdef";
		String sa2 = "";
		
		System.out.println(sa1.isEmpty());
		System.out.println(sa2.isEmpty());
		System.out.println(sa2.equals(""));
		System.out.println(sa2 =="");
		
		System.out.println("====================");
		String sv1 = "123";
		//int n1 = (int)sv1;
		int n1 =Integer.parseInt(sv1);
		System.out.println(n1 * 3.5);
		
		int n2 = Integer.valueOf(sv1);
		System.out.println(n2*3.5);
		
		//-------------------------------------
		//문자열을 실수로 변경
		String sv2 = "189.345";
		double n3 = Double.parseDouble(sv2);
		System.out.println(n3 /10);
		
		
		//-------------------------------------
		//모든 숫자를 글자로
		int num1 = 123;
		String sv4 = num1+"";
		String sv5 = String.valueOf(num1);
		
		double num2 = 123.4567;
		String sv6 = String.valueOf(num2);
		
	}
}
