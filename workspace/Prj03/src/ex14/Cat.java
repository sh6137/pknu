package ex14;

public class Cat extends Animal{

	public void climb() {
		System.out.println("켓타워를 올라갑시다.");
	}
	@Override
	public void cry() {
		System.out.println(name + "애옹");
	}
	

}
