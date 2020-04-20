package ex03;

public class Professor extends Person{
	String subject;
	
	public void teaching() {
		System.out.println(name + " " + subject + " 강의합니다.");
	}
}
