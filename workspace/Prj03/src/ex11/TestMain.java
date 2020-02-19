package ex11;

public class TestMain {
	public static void main(String[] args) {
//		Person p1 = new Person();
//		p1.name = "아이유";
//		p1.tel = "010-1234-1234";
//		
		Person p1 = new Person("아이유","010-1111-1111");

		p1.info();
		System.out.println("p1 이름" + p1.getName());
		
		Person ptemp = new Person();
		
		ptemp.setName("아이유");
		System.out.println(ptemp.getName());
		
	}
}
