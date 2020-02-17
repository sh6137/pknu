package ex03;

public class Sachic {
	//filed
	private int v1;
	private int v2;
	
	//getter setter
	public int getV1() {
		return v1;
	}
	public void setV1(int v1) {
		if(0<=v1 && v1 <=Integer.MAX_VALUE)
			this.v1 = v1;
		else
			this.v1=40;
	}
	public int getV2() {
		return v2;
	}
	public void setV2(int v2) {
		this.v2 = v2;
	}
	//constructor : 생성자
	public Sachic() {}; //기본생성자
	
	
	//method
	public int add() {
		return getV1()+getV2();
	}
	public int sub() {
		return getV1()-getV2();
	}
	public int mul() {
		return getV1()*getV2();
	}
	public int div() {
		return getV1()/getV2();
	}
	
}
