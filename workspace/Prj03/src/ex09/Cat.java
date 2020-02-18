package ex09;

public class Cat {
	String name;
	int age;
	
	
	
	public void eat(String food) {
		System.out.println(this.name + "가 " +food + "를 먹는다");
	}
	
	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}
	
	
	public void meow() {
		System.out.println("야옹");
	}
}
