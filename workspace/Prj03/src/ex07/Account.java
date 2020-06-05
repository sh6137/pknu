package ex07;

public class Account {
	//Fields
	private String name;
	private double money;
	
	public Account() {}
	
	//신규계좌생성
	public Account(String name,double money) {
		this.name = name;
		this.money= money;
	}
	
	//Methods
	//잔액확인
	public double getBalance() {
		return this.money;
	}
	//출금(인출)
	public void withdraw(double amount) throws Exception {
		if(this.money - amount >= 0 &&amount > 0) {
			this.money-=amount;
			System.out.println(amount + "가 출금 되었습니다.");
		}else {
		throw new Exception("잔액이 부족합니다.");
		}
		
	}
	//입금
	public void deposit(double amount) {
		if(amount > 0)
			this.money+=amount;		
		else
			System.out.println("입금액을 정확히 입력하세요");
	}
	public String info() {
		String fmt = "%s 님의 계좌 잔액은 %f 원 입니다.";
		String msg = String.format(fmt, name,money);
		return msg;
	}

	@Override
	public String toString() {
		String fmt = "%s 님의 계좌 잔액은 %f 원 입니다.";
		String msg = String.format(fmt, name,money);
		return msg;
	}
	
	
}
