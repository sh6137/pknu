package ex11;

public class TestMain2 {
	public static void main(String[] args) {
		Professor p1 = new Professor();
		p1.setName("쯔위");
		p1.info();
		
		p1 = null;
		if(p1 != null) {			
			p1.info();
		}
	}
}
