package ex03;

public class TestMain {
	public static void main(String[] args) {
		// 객채 상속
		//상속 : 공콩되는 부분을 추출하여 부모클래스로 구분한다.
		
		Person p1 = new Person();
		p1.name = "차은우";
		p1.tel  = "010-1234-1111";
		
		System.out.println(p1.toString());
		
		Professor pr1 = new Professor();
		pr1.name = "소미";
		pr1.tel = "010-1234-2222";
		pr1.subject= "과학";
		System.out.println(pr1);
		pr1.teaching();
		
		Student s1 = new Student();
		s1.name = "학생1";
		s1.tel = "010-1234-3333";
		System.out.println(s1);
		s1.study();
	}
}
