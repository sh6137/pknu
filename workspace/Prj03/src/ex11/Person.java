package ex11;

public class Person {
	private String name;
	private String tel;
	
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public Person() {
		System.out.println("기본생성자");
	};
	

	public Person(String name, String tel) {
		this(); // 기본생성자 호출
		this.name = name;
		this.tel = tel;
	}


	public void info() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + tel);
	}
}
