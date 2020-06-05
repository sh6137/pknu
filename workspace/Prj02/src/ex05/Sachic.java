package ex05;

public class Sachic {
	//Fields : 필드(멤버변수)
	private int v1;
	private int v2;
	
	//getter setter 게터 세터
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
	//constructor 생성자
	//기본생성자 : 전역변수 초기화	
	public Sachic() {
		System.out.println("기본생성자");
		this.v1 = 0;
		this.v2 = 0;
	}
	//overload 된 생성자
	public Sachic(int v1, int v2) {
		System.out.println("인자가 있는 생성자");
		this.v1 = v1;
		this.v2 = v2;
	}
	//method 메소드
	public int add(int v1,int v2) {
		return v1 + v2;
	}
	public int sub(int v1,int v2) {
		return v1 - v2;
	}
	public int mul(int v1,int v2) {
		return v1 * v2;
	}
	public int div(int v1,int v2) {
		return v1 / v2;
	}
	//method2
	public int add() {
		return this.v1 + this.v2;
	}
	public int sub() {
		return this.v1 - this.v2;
	}
	public int mul() {
		return this.v1 * this.v2;
	}
	public int div() {
		return this.v1 / this.v2;
	}
	
}
