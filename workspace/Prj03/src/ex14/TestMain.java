package ex14;

public class TestMain {
	public static void main(String[] args) {
		Cat cat1  = new Cat();
		cat1.name = "김애옹";
//		cat1.climb();
//		cat1.cry();
		
		Dog dog = new Dog();
		dog.name = "댕댕이";
//		dog.swim();
//		dog.cry();
		
		
		//life(cat1,"참치");
		life(dog, "참");
		
	//	Animal beast = new Animal();
	}

	private static void life(Animal pet, String food) {
		pet.cry();
		pet.eat(food);
		if(pet instanceof Cat)
			((Cat)pet).climb();
		if(pet instanceof Dog)
			((Dog)pet).swim();
	}
}
