package ex03;

public class Array {
	public static void main(String[] args) {
		//배열
		//같은 이름과 type 을 가진 연속적인 변수들의 모음
		//배열의 크기는 변경 할 수 없다. (Arrays 클래스를 배우면 가능)
		int[] a = new int[6];
		
		for(int i=0;i < a.length; i++) {
			a[i] = (int)(Math.random()*45)+1;
			for(int j=0; j<i ; j++) {
				if(a[i] == a[j]) {
					i--;
				}
			}
		}
		
		for(int j =0 ; j<a.length ; j++) {
			System.out.println(a[j]);
		}
		System.out.println("------");
		
		int tmp =0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i]>a[j]) {
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
