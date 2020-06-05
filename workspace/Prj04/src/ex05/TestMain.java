package ex05;
class Member{
	String id;
	public Member() {
		
	}
	public Member(String id) {
		super();
		this.id = id;
	}
	
}
class Member2{
	String id;
	public Member2() {
		
	}
	public Member2(String id) {
		super();
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Member2 mm = (Member2)obj;
		if(this.id.equals(mm.id))
			return true;
		else
			return false;
		
	}
	
	
	
	
}
public class TestMain {
	public static void main(String[] args) {
		String name1 = "이순신";
		String name2 = "이순신";
		System.out.println(name1 == name2);
		//hashcode 비교 : 문자열 비교시 사용금지
		System.out.println(name1.equals(name2)); // 값을 비교
		
		Member m1 = new Member("blue");
		Member m2 = new Member("blue");
		Member m3 = new Member("red");
		
		//class 안의 equal 는 재정의하지 않으면 ==와 동일
		//hashcode 비교
		System.out.println(m1 == m2);
		System.out.println(m1 == m3);
		
		System.out.println();
		System.out.println();
		
		Member2 mm1 = new Member2("blue");
		Member2 mm2 = new Member2("blue");
		Member2 mm3 = new Member2("red");
		
		
		System.out.println(mm1.equals(mm2));
		System.out.println(mm1.equals(mm3));
	}
}
