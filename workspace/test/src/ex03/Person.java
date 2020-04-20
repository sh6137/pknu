package ex03;

//공통부분
public class Person {
	//field
	String name;
	String tel;
	
	//override : 재정의
	@Override
	public String toString() {
		return "Person [name=" + name + ", tel=" + tel + "]";
	}
	
	
}
