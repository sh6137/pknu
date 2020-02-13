package ex05;

public class Test03 {
	static int[] data ;
	public static void main(String[] args) {
		//bubble sort : ascending
		
		data = new int[] {8,7,9,5,3,};
		
		disp_arr();
		bubble_sort_asc();
		disp_arr();
		System.out.println("*--------*");
		select_sort();
		disp_arr();
	}
	private static void select_sort() {
		
		int tmp = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = i+1; j < data.length; j++) {
				if(data[i]>data[j]) {
					tmp = data[i];
					data[i]=data[j];
					data[j]=tmp;
				}
			}
		}
		
	}
	private static void bubble_sort_asc() {
		int n = data.length;
		int tmp=0;
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-1-i; j++) {
				if(data[j]>data[j+1]) {
					tmp = data[j];
					data[j]=data[j+1];
					data[j+1]=tmp;
				}
			}
		}
		
	}
	private static void disp_arr() {
		
		for (int i = 0; i < data.length; i++) {
			System.out.printf("%4d" ,data[i]);
			
		}
		System.out.println();
		
	}
	
}
