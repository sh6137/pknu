package ex03;

class Member{
	private String id;
	private String name;
	private String password;
	private int age;
	private boolean adult;
	
	//게터 /세터
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		if(age > 19)
			this.adult = true;
		else
			this.adult = false;
				
	}

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}
	
	public Member(String id, String name, String password, int age) {
		this.id = id;
		this.name =name;
		this.password = password;
		this.age = age;
		if(age > 19)
			this.adult = true;
		else
			this.adult = false;
	}
	public Member() {
		
	}
	

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + ", adult=" + adult
				+ "]";
	}
	
}

public class TestMain {
	public static void main(String[] args) {
		Member m1 = new Member("1", "길동이", "1234", 27);
		System.out.println(m1);
		Member m2 = new Member("1", "길tns이", "1234", 20);
		System.out.println(m2);
		
	//	Member m3 = new Member("1", "길동이", "1234", 27);
		Member m3 = m1;
		System.out.println(m3);
		
		m1.setAge(17);
		System.out.println(m1);
	// 	객체복사 shallow copy 얕은 복사
		member_copy(m2, m3);
		System.out.println("m2를 카피한 m3");
		System.out.println(m3);
	//	deepcopy 깊은복사
		Member m4 = member_deepcopy(m2);
		System.out.println(m4);
	}

	private static Member member_deepcopy(Member src) {
		Member dest = new Member();
		dest.setId(src.getId()); //dest.id <- src.id
		dest.setName(src.getName());
		dest.setPassword(src.getPassword());
		dest.setAge(src.getAge());
		return dest;
	}

	private static void member_copy(Member src, Member dest) {
		dest.setId(src.getId()); //dest.id <- src.id
		dest.setName(src.getName());
		dest.setPassword(src.getPassword());
		dest.setAge(src.getAge());
	}
}
