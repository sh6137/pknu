package ex05.collrection03;

public class Member {
	private String name;
	private int age;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Member(String name, int age) {	
		this.name = name;
		this.age = age;
	}


	//중복 제거하기
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member mem = (Member) obj;
			return mem.name.equals(this.name) &&
					(mem.age == this.age);
		}
		return true;
	}

	
}
