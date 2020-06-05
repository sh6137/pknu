package ex05;

public class Test02 {
	public static void main(String[] args) {
		int money = 78350;
		int m = money;
		int[] currency = {
				50000, 10000, 5000, 1000, 500, 100, 50 , 10, 5, 1
		};
		int[] cnt = new int[10];
		
		for (int i = 0; i < cnt.length; i++) {
			cnt[i] = m / currency[i];
			m = m % currency[i];
		}
		System.out.println(" "+money);
		
		for (int i = 0; i < cnt.length; i++) {
			
			System.out.printf("%d원 : %d 장\n", currency[i], cnt[i]);
			
		}
		
	}
}
