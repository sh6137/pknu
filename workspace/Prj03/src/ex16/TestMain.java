package ex16;

//다중상속 불가능
//extends 하나의 클래스만 상속 가능
/*
class 오리{	}
class 너구리  {	}
class 오리너구리 extends 오리,너구리 {	} error
*/

interface Duck{
	public void swim();
}
interface Racoon{
	public void dig();
}
class DuckRacoon implements Duck, Racoon{

	@Override
	public void dig() {
		System.out.println("땅을 팝니다.");
		
	}

	@Override
	public void swim() {
		System.out.println("헤엄친다.");
	}
	
}
public class TestMain {
	public static void main(String[] args) {
		DuckRacoon dr = new DuckRacoon();
		
		dr.dig();
		dr.swim();
		
	}
}
