package ex03;

public class Ex02 {
	public static void main(String[] args) {
		int a=7, b =2;
		int c;
		
		c = add(a,b);
		
		System.out.printf("a=%d , b=%d ,c =%d",a,b,c);
		/*
		 *  %-10d: 전체 10자리에 10진수를 출력
		 *  		:-왼쪽정렬(기존정렬 오른쪽- 숫자)
		 *  %d:decimal
		 *  %o:octal
		 *  %x:hexa
		 *  %s:string
		 *  %f:float, double
		 *  %c:char
		 */
	}
	private static int add(int a, int b){
		int c;
		c = a+b;
		return c;
	}
}
