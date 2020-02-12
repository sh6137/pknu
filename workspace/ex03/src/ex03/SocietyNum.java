package ex03;

public class SocietyNum {
	public static void main(String[] args) {
		int[] nid = {9,3,1,0,0,1,1,1,1,0,1,1,1};
		int[] m	  = {2,3,4,5,6,7,8,9,2,3,4,5};
		
		int sum=0;
		for (int i = 0; i < m.length; i++) {	
			sum = sum+nid[i] * m[i];
		}
		int chk = 11 - sum%11;
		if(chk>10)
			chk=chk-10;
		System.out.println(sum);
		System.out.println(chk);
		
		if(chk == nid[12] ) {
			System.out.println("정확한 번호입니다.");
		}
		else {
			System.out.println("틀린번호입니다.");
		}
	}	
}
