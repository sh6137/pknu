package ex06;

public class Text01 {
	public static void main(String[] args) {
		String s1 = "Hello 李이순신 123 A";
		String s2 = new String("안녕하세요 Mark 31");
		
		System.out.println(s1);
		System.out.println(s2);
		
		//문자열길이
		int len1 = s1.length();
		System.out.println(len1);
		
		//특정위치의 문자
		char c1 = s1.charAt(0);
		System.out.println(c1);
		System.out.println(s1.codePointAt(15));
		
		//문자열비교
		String s3 = "이순신";
		String s4 = "이이";
		boolean isSame1 = s3 =="이순신"; //문자열 비교시 사용금지
		System.out.println(isSame1);//true : 위치비교, data 비교X;
		boolean isSame2 = s3==s4; //문자열 비교시 사용금지
		System.out.println(isSame2); //true : 위치비교, data 비교X;
		boolean isSame3 = s3.equals("이순신"); //문자비교추천
		System.out.println(isSame3); //true : 위치비교X, data 비교0;
		
		String s5 = new String("이순신");
		String s6 = new String("이순신");
		
		boolean isSame4 =s5 ==s6;
		System.out.println(isSame4); //false
		
		boolean isSame5 =s5.equals(s6);
		System.out.println(isSame5); //true
		
		//문자열 크기비교, 순서
		String s7 = "이순신";
		String s8 = "이이";
				
		int eq = s7.compareTo(s8);	//문자열 순서비교
		System.out.println(eq);		//음수 :앞문자가 작다
									//0같다
									//앞문자열이 크다
		eq = s7.compareToIgnoreCase(s8);
		System.out.println(eq);
		
		//문자열 결합
		String s9 = s7+","+s8;
		System.out.println(s9);
		String s10 = s7.concat(",").concat(s8); // method chaining
		System.out.println(s10);
		
		
		
		//StringBulider : 문자열 연산시 속도가 빠름
							//thread safe X
		
		//StringBuffer : 문자열 연산시 속도가 빠름
							//thread safe x
		
		StringBuilder sb = new StringBuilder();
		sb.append(s8);
		sb.append("-------");
		sb.append(s8);
		System.out.println(sb.toString());
		
		System.out.println(sb.length());
		System.out.println(sb.substring(5));
		
		
	}
}
