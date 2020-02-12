package ex03;

public class Ex05 {
	public static void main(String[] args) {
		int [][]arr = new int[5][4];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int)(Math.random()*45)+1;
			}
		}
		
		
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
	}
}
