package ex04;

class Member implements Cloneable{
	String id;
	String name;
	String password;
	int age;
	boolean adult;
	
	
	public Member(String id, String name, String password, int age) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		if(age > 19)
			this.adult = true;
		else
			this.adult = false;
	}


	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + ", adult=" + adult
				+ "]";
	}


	public Member getClone() {
		//clone() 객체를 복사해 준다.
		//CloneNotSupportedException 를 발생시키므로 예외처리
		//반드시 implements Cloneable 를 사용 : 안하면 예외발생
		Member cloned = null;
		try {
			cloned = (Member)clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cloned;
	}
	
	
}

public class TextMain {
	public static void main(String[] args) {
		Member m1 = new Member("blue", "하늘이", "1111", 17);
		System.out.println(m1);
		
		//getClone() : 객체를 복사해준다.
		Member m2 = m1.getClone();
		System.out.println(m2);
		
		m1.age = 29;
		System.out.println(m2.age);
	}
}
