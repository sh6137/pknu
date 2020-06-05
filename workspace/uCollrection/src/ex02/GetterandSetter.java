package ex02;
class Student{
	private int num;
	private String name;
	private int score;
	
	
	public Student(int num, String name, int score) {
		
		this.num = num;
		this.name = name;
		if(0<=score && score <=100)
			this.score = score;
		else
			this.score = 0;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
public class GetterandSetter {
	public static void main(String[] args) {
		Student s1  = new Student(2,"길동",100);
		s1.getName();
		System.out.println(s1.getName());
		s1.setName("dfdf");
		System.out.println(s1.getName());
		/*
		s1.num =1;
		s1.name="홍길동";
		s1.score=100;
		System.out.println(s1.num + "," + s1.name + "," + s1.score);
		s1.score=1000;
		*/
	}
}
