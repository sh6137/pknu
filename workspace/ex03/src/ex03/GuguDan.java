package ex03;

public class GuguDan {
	public static void main(String[] args) {
		int mul;
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 5; j++) {
				mul =i*j;
				System.out.print( " "+j + " * " + i+ " = " + mul +" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		for (int i = 1; i <= 9; i++) {
			for (int j = 6; j <= 9; j++) {
				mul =i*j;
				System.out.print( " "+j + " * " + i+ " = " + mul +" ");
			}
			System.out.println();
		}
		System.out.println(2468);
		
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 8; j=j+2) {
				mul =i*j;
				System.out.print( " "+j + " * " + i+ " = " + mul +" ");
			}
			System.out.println();
		}
		System.out.println(3579);
		for (int i = 1; i <= 9; i++) {
			for (int j = 3; j <= 9; j=j+2) {
				mul =i*j;
				System.out.print( " "+j + " * " + i+ " = " + mul +" ");
			}
			System.out.println();
		}
		
	}
}
