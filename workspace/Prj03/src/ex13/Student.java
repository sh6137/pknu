package ex13;

public class Student {
	private String name;
	private String tel;
	private int year;

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


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public Student() {}
	
	public Student(String name, String tel, int year) {
		
		this.name = name;
		this.tel = tel;
		this.year = year;
	
	}
	
	
}
