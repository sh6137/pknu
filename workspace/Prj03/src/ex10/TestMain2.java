package ex10;

public class TestMain2 {
	public static void main(String[] args) {
		
		Cat cat = new Cat();
		cat.name = "김애옹";
		
		Dog dog = new Dog();
		dog.name = "댕댕";
				
		Cow cow = new Cow();
		cow.name="음무";
		animal_eat(cat);
		animal_eat(dog);
		animal_eat(cow);
	}



	private static void animal_eat(Animal beast) {
		beast.eat("고기");
		if(beast instanceof Dog)
		((Dog)beast).bark();
		if(beast instanceof Cat)
		((Cat)beast).meow();
		if(beast instanceof Cow)
			((Cow)beast).muu();
	}
	
}
