package ex05;

public class Text07 {
	public static void main(String[] args) {
		int a = 7;
		
		System.out.println("main() : " + a);
		a = func1(a);
		System.out.println("main() : " + a);
		
		System.out.println("///////////////////////////////////////////");
		int []arr = new int[3];
		arr[0] =10;
		arr[1] =20;
		arr[2] =30;
		
		System.out.println("배열처리");
		System.out.printf("%d %d %d\n", arr[0], arr[1], arr[2]);
		double_array(arr);
		System.out.printf("%d %d %d\n", arr[0], arr[1], arr[2]);
		
	}

	private static void double_array(int [] arr) {
		arr[0] = arr[0] *3;
		arr[1] = arr[1] *3;
		arr[2] = arr[2] *3;
	}

	private static int func1(int a) {
		System.out.println("func1() : " + a);
		a=a*3;
		System.out.println("func1() : " + a);
		
		return a;
	}
}
