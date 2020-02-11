package ex03;

public class Ex03 {
	public static void main(String[] args) {
		
		for(int i=0 ;i<5;i++) {
			for(int j=0; j<5;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("----1--------------------------");
		
		for(int i=0; i<5;i++) {
			
			for(int j=0; j<5;j++) {
				System.out.print(i+1);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("-----2-------------------------");
		
		for(int i=0; i<5; i++) {
			
			for(int j=0; j<5 ; j++) {
				System.out.print(j+1);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("-----3-------------------------");
		
		for(int i=0;i<5;i++) {
			for(int j=i; j<5+i;j++) {
				System.out.print(j+1);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("-----4-------------------------");
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("-------5-----------------------");
		
		for(int i=0; i<5 ;i++) {
			for(int j=0; j<5-i ;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("------6------------------------");
		
		for(int i=0; i<5 ; i++) {
			
			for(int j=0; j<5-i ; j++) {
				System.out.print("*");
			}
			System.out.println();
			for(int k=0; k<=i; k++) {
				System.out.print(" ");
			}
		}
		
		System.out.println();
		System.out.println("-------7-----------------------");
		
		
		for(int i=0; i < 5; i++) {
			for(int j=0;j<5-i-1 ;j++) {
				System.out.print(" ");
			}
			for(int k=0; k<=i ; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("-------8-----------------------");
		
		for(int i=1; i<=5; i++) {   
            for (int j=1; j<=5-i; j++) {
                System.out.print(" "); //공백
            }
            for (int j=1; j<=i*2-1; j++) { //나머지 별 한방에채우기.
                System.out.print("*");
            }
            System.out.println();
        }
		 for(int i=4; i>0; i--) {    //하단
             for (int j=4; j>=i; j--) {
                 System.out.print(" "); //공백
             }
             for (int j=1; j<=i*2-1; j++) {
                 System.out.print("*");
             }
             
             System.out.println();
         }
		 
		System.out.println();
		System.out.println("-------9-----------------------");
		for(int i=0 ;i <5; i++) {

			for(int j=0; j<5-i; j++) {
				System.out.print("*");
				
			}
			for(int k=0;k<=i*2-1;k++) {
				System.out.print(" ");
			}
			for(int j =4; j>i-1 ; j--) {
				System.out.print("*");
			}
			System.out.println(); //윗부분	
		}
		for(int i=1 ; i <=5 ;i++) {
			for(int j=1 ;j<=i ; j++) {
				System.out.print("*");
			}
			for(int k=1; k<11-i*2; k++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
