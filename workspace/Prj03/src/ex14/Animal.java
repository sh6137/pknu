package ex14;

abstract public class Animal {
	String name;
	
	public void eat(String food) {
		System.out.println(name + "이가" + food + "을 먹는다.");
	}
	
	abstract public void cry();
}
