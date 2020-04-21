package ex01.generic2;
class Apple{}
class Banana{}
class Box<Apple>{
	Apple t;
}
class Box2<Banana>{
	Banana banana;
}

public class TestMain {
	public static void main(String[] args) {
		Apple redApple = new Apple();
		Box<Apple> box = new Box<Apple>();
		box.t = redApple;
		
		Apple Apple1 = box.t;
		
		//box.t = "홍길동"; //에러
		
		
	}
}
