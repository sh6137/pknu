package ex09;

public class Dog {
	String name;
	int age;
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
	
	
	public void eat(String food) {
		System.out.println(this.name + "가 " +food + "를 먹는다");
	}
	public void bark() {
		System.out.println("멍멍");
	}
}