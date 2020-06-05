package ex03;

public class Ex06 {

	static char [][] shape;
	public static void main(String[] args) {	
		shape = new char[5][5];
		
		init_array();
		fill_array();
		disp_array();
		
		System.out.println("=============================");
		init_array();
		fill_array2();
		disp_array();
	}
	
	public static void init_array() {
		for(int i =0;i<5;i++) {
	    	for (int j = 0; j < shape[0].length; j++) {
	    		shape[i][j] = ' ';
		    }
		}	
	}
	
	public static void fill_array() {
		for(int i =0;i<5;i++) {
	    	for (int j = 0; j < shape[0].length; j++) {
	    		shape[i][j] = '*';
		    }
		}
	}
	
	public static void fill_array2() {
		for(int i =0;i<5;i++) {
			for (int j = i; j < 5; j++) {
				shape[i][j] = '*';
			}
		}
	}
	
	
	
	public static void disp_array() {
		for(int i =0;i<5;i++) {
	    	for (int j = 0; j < shape[0].length; j++) {
	    		System.out.printf("%c", shape[i][j]);
		    }
	    	System.out.print("\n");
		}	
	}
}
