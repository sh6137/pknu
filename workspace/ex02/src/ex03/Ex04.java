package ex03;

public class Ex04 {
	public static void main(String[] args) {
		//1-10 까지 구하기
		int sum = 0;
		for(int i = 1 ; i <=10 ;i++ ) {
			sum = sum+i;
			
		}
		
		System.out.println(sum);
		
		//1+3+5+7+9+11+;;;;
		
		int sum3 = 0;
		int j1 = -1;
		for(int i = 1 ; i <=10 ;i++ ) {
			j1= j1+2;
			sum3 = sum3+j1;
			
		}
		System.out.println(sum3);
		
		//1+ 1+2+ 1+2+3 +1+2+3+4 +1+2+3+4+5
		int sum2=0;
		int total=0;
		int j;
		for(int i = 1; i <= 5;i++) {
			
			for(j = 0 ; j<i; j++) {
				j=j+i;
			}
			sum2 = sum2+i;
			System.out.println(sum2+" "+i);
		total = total+sum2;	
		System.out.println("    dfs"+total);
		}
		System.out.println(total);
		
		
		
		//1+2+4+8+16+32+64+128+256+512+1024.....
		int total2 = 0;
		
		double p = Math.pow(2, 9);
		System.out.println(p +": math");
		for(int i=1; i<=p;i=i*2) {
			total2 = total2+i;
			System.out.println(total2);
		}
		System.out.println(total2);
	}
}
