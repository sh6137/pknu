package ex05;

public class Text06 {
	public static void main(String[] args) {
		int a =7, b=2;
		
		System.out.printf("a=%d b=%d\n",a,b);
		
		swap(a,b);
		System.out.printf("a=%d b=%d\n",a,b);
		
	}

	private static void swap(int a, int b) {
		int temp;
		temp = a;
		a = b;
		b = temp;
		
	}
}
