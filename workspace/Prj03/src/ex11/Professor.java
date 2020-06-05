package ex11;

public class Professor extends Person{
	
	private String subject;
	
	public Professor() {
		
	}
	
	
	public Professor(String name, String tel) {
		super(name, tel);
	}
	
	public Professor(String name, String tel, String subject) {
		super(name, tel);
		this.subject = subject;
	}
	
	
	//method
	public void teaching() {
		System.out.println(getName()+"...교수님이 " + subject );
	}


	@Override
	public void info() {
		super.info();
		System.out.println("과목 : " + subject);
	}
	
	
	
	
}
