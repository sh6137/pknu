package ex01.generic1;

class Apple{
	
}
class Banana{
	
}
class Box{
	Object fruit;
}


public class TestMain {
	//제네릭 사용 안했을때
	public static void main(String[] args) {
		Box box = new Box();
		Apple redApple = new Apple();
		Banana yellowBanana = new Banana();
		
		//박스에 저장
		box.fruit = redApple;
		Apple apple1 = (Apple) box.fruit;
		
		box.fruit = "홍길동";
		String str = (String) box.fruit;
	}
	
}
