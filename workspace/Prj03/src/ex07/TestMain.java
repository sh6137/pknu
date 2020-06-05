package ex07;

public class TestMain {
	public static void main(String[] args) {
		Account acc1 = new Account("홍길동",100000.0);
		Account acc2 = new Account("임꺽정",10000.0);
		
		System.out.println(acc1.info());
		System.out.println(acc2.info());
		
		acc1.deposit(90000.0);
		acc2.deposit(120000.0);
		
		System.out.println(acc1.info());
		System.out.println(acc2.info());
		
		try {
			acc2.withdraw(50000.0);
			//System.out.println(acc2.toString());
			System.out.println(acc2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		

	}
}
