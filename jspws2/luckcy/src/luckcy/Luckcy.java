package luckcy;

import java.util.Random;

public class Luckcy {
	public static void main(String[] args) {
		
		Random random = new Random();
		
		while(true) {
			int i = 0;
			int b = random.nextInt(4)+1;
			System.out.print(b +"조 ");
			while(i<6) {
				
				int a = random.nextInt(10);
				System.out.print(a + " ");
				i++;
			}
			System.out.println("");
		}
	
		
		
	}
}
