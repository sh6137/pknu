package ex14;

public class Dog extends Animal {

	public void swim() {
		System.out.println(name + "가 개헤엄을 칩니다.");
	}
	@Override
	public void cry() {
		System.out.println(name + "이가 멍멍멍");
	}

}
