package ex10;

public class TestMain {
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.name = "아롱이";
		cat.age = 4;
		cat.eat("고등어");
		cat.meow();
		
		Dog dog  = new Dog();
		dog.name = "다롱이";
		dog.eat("사료");
		dog.bark();
		
//		Animal animal = new Animal();
//		
//		animal.name = cat.name;
//		
//		animal.eat("참치");
//		
//		
//		Cat cat3 = (Cat) animal;
//		System.out.println(cat3.name);
//		cat3.eat("Tuna");
		
		Animal anim = new Cat(); //upcasting
		anim.name = "아";
		anim.eat("참치캔");
		Cat cat3 = (Cat)anim; //downcasting
		cat3.meow();
		
	}
}
