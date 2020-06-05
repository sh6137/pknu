package ex04;

public class TestMain {
	public static void main(String[] args) {
		Dog dog1 = new Dog();
		dog1.name = "백구";
		dog1.age = 3;
		dog1.eat();
		dog1.bark();
		
		Cat cat1 = new Cat();
		cat1.name = "냐옹이";
		cat1.age = 1;
		cat1.eat();
		cat1.meow();
		
		Animal an1 = new Animal();
		an1.name = "음머";
		an1.age = 6;
		an1.eat();
		
		/*
		an1 = dog1;
		an1.eat();
		
		Dog newDog = dog1;
		newDog.eat();
		
		//newDog = cat1;//error type 변환불가능
		newDog = (Dog)an1; //casting 가능 : 자식 <-(자식)부모
		newDog.eat();
		*/
		
		
		System.out.println("+++++++++++++++++++++");
		animal_eat(an1);
		animal_eat(dog1);
		animal_eat(cat1);
	}

	private static void animal_eat(Animal animal) {
		animal.eat();
		if(animal instanceof Dog) {
			((Dog) animal).bark();
		}
		if(animal instanceof Cat) {
			((Cat) animal).meow();
		}
	}

	
}
