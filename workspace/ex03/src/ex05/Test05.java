package ex05;

public class Test05 {
	static int[] data ;
	public static void main(String[] args) {
		
		
int [] data = new int[] {8, 7, 9, 5, 3 };
		
		disp_array( data );		
		selection_sort_asc(data);		
		disp_array(data);
	}

	private static void selection_sort_asc(int[] data) {
		int n = data.length;
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if( data[i] > data[j]  ) {
					int temp  = 0;
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		
	}

	private static void disp_array(int [] data ) {
		for (int i = 0; i < data.length; i++) {
			System.out.printf("%4d ", data[i] );
		}		
		System.out.println();		
	}

}