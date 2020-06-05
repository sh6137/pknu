package ex11;

public class TestMain3 {
	public static void main(String[] args) {
		Professor p1 = new Professor("아이유", "010-1234-1234");
		p1.info();
		p1.teaching();
		
		Professor p2 = new Professor("쯔위", "010-1234-1234" , "댄스");
		p2.info();
		p2.teaching();
		System.out.println();
		System.out.println();
		Student std = new Student("어른유" , "010-1234-1234" , 100);
		std.info();
		std.testing();
		std.study();
	}
}
