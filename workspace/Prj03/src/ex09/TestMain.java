package ex09;

public class TestMain {
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.name = "야옹이";
		cat.age = 4;
		System.out.println(cat);
		cat.eat("생선");
		
		Dog dog = new Dog();
		dog.age = 3;
		dog.name ="멍멍이";
		
		System.out.println(dog);
		dog.eat("고기");
		
		
		Cow cow = new Cow();
		cow.name = "쥬니";
		cow.age = 5;
		System.out.println(cow);
		cow.eat("여물");
	}
}
