package ex15;

public class TestMain {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.name = "tpqk";
		dog.cry();
		
		Cat cat = new Cat();
		cat.name = "김애옹";
		cat.cry();
		System.out.println();
		System.out.println();
		pet_action(cat);
		pet_action(dog);
	}

	private static void pet_action(IPet pet) {
		pet.cry();
	}
}
