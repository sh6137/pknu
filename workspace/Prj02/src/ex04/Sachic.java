package ex04;

public class Sachic {
	//field
	private int v1;
	private int v2;
	
	//Constructor 생성자
	public Sachic(int v1, int v2) {
		//입력값 체크
		this.v1 = v1;
		this.v2 = v2;
	}
	public Sachic() {
		// TODO Auto-generated constructor stub
	}



	//getter setter
	public int getV1() {
		return v1;
	}
	public void setV1(int v1) {
		this.v1 = v1;
	}
	public int getV2() {
		return v2;
	}
	public void setV2(int v2) {
		this.v2 = v2;
	}
	
	
	
	
	//method
	public int add() {
		return v1+v2;
	}
	public int sub() {
		return v1-v2;
	}
	public int mul() {
		return v1*v2;
	}
	public int div() {
		return v1/v2;
	}
	
}
