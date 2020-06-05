package ex05;

public class Text08 {
	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		
		int v1,v2,v3,v4;
		
		int[] v = func1(num1,num2,num3);
		
		System.out.println("모두 더하기 : " + v[0]);
		System.out.println("모두 빼기 : " + v[1]);
		System.out.println("모두 곱하기 : " + v[2]);
		System.out.println("모두 나누기 : " + v[3]);
	}

	private static int[] func1(int num1, int num2, int num3) {
		int[]v = new int[4];
		v[0] = num1 + num2 + num3;
		v[1] = num1 - num2 - num3;
		v[2] = num1 * num2 * num3;
		v[3] = num1 / num2 / num3;
		return v;
	}
}
