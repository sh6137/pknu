package ex05;
class Member{
	private String id;
	public Member(String id) {
		this.id = id;
	}
	//추가 
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			if(this.id.equals(member.id)) { //문자열비교
				return true;
			}
			else
				return false;
		}
		return super.equals(obj); //주소비교
	}
	
}
public class TestMain {
	public static void main(String[] args) {
		Member m1 = new Member("sky");
		Member m2 = new Member("blue");
		Member m3 = new Member("blue");
		
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		
		System.out.println(m1==m2);
		System.out.println(m2==m3);
		
		System.out.println(m2.equals(m3));
		//equals() 는 재정의하지 않으면 주소를 비교한다.
		//객체의 인스턴스를 비교하려면 equals()를 비교하도록 재정의 해야한다.
		//String 의 경우에는 값을 비교하도록 재정의 되어있다.

		System.out.println("*****************");
		String name1 = "이순신";
		String name2 = "이순신";
		
		System.out.println(name1 == name2); //사용안됨 주소비교
		System.out.println(name1.equals(name2)); // String 값 비교
		
		String name3 = new String("이순신");
		String name4 = new String("이순신");
		
		System.out.println(name3 == name4);
		System.out.println(name3.equals(name4));
		
		//문바열 비교는 무조건 equals 사용
	}
}
