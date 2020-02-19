package ex11;

public class Student extends Person{
	private int jumsu;

	public int getJumsu() {
		return jumsu;
	}

	public void setJumsu(int jumsu) {
		this.jumsu = jumsu;
	}
	
	public Student() {
		
	}
	public Student(String name, String tel , int jumsu) {
		super(name, tel);
		this.jumsu = jumsu;
	}

	public void testing() {
		System.out.println(getName() + " : " + jumsu);
	}
	public void study() {
		System.out.println(getName() + ": 공부중");
	}

	@Override
	public void info() {
		
		super.info();
		System.out.println("점수 : " + jumsu);
	}
	
}
