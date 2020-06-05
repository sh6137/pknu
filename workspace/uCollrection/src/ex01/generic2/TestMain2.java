package ex01.generic2;
class Apple2{}
class Melon{}

//T : Type 의 약자 들어온 type 에 맞게 설정
class NewBox<T>{
	T t;
}
public class TestMain2 {
	public static void main(String[] args) {
		Apple2 greenApple =  new Apple2();
		NewBox<Apple2> box1 = new NewBox<Apple2>(); 
		box1.t = greenApple;
		Apple2 newApple = box1.t;
		NewBox<String> box2 = new NewBox<String>();
		box2.t = "홍길동";
		String name = box2.t;
		System.out.println(name);
		System.out.println(box1.t);
		
		Melon melon = new Melon();
		NewBox<Melon> box3 = new NewBox<>();
		box3.t = melon;
		Melon newMelon = box3.t;
		
		//int (X) -> Integer(Wrapper Class)
		NewBox<Integer> box4 = new NewBox<>();
		box4.t =12345;
		int num1 = box4.t;
		System.out.println(num1);
		
	}
}
