package ex07상속;

//인터페이스를 활용한 다중상속 구현
//자바 클래스는 다중상속 불가능
//-> 인터페이스 이용해서 다중상속을 구현

//1. class + interface

interface Racoon{
	public void dig();
}


class Duck{
	public void swim() {
		System.out.println("헤엄친다");
	}
}


// 2. interface + interface

class DuckRacoon extends Duck implements Racoon{

	@Override
	public void dig() {
		System.out.println("땅을 판다");
	}
	
}

public class TestMain {
	public static void main(String[] args) {
		DuckRacoon dr = new DuckRacoon();
		dr.swim();
		dr.dig();
	}
	
}
