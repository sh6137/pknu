package ex07상속;

interface IDuck{
	void swim();
}

interface IRacoon{
	void dig();
}

class DuckRacoon2 implements IDuck, IRacoon{

	@Override
	public void dig() {
		System.out.println(" 땅을판다 ");	
	}

	@Override
	public void swim() {
		System.out.println(" 헤엄치다");
	}
	
}

public class TestMain2 {
	public static void main(String[] args) {
		DuckRacoon2 dr = new DuckRacoon2();
		dr.swim();
		dr.dig();
	}
}
