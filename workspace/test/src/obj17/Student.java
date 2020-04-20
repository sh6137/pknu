package obj17;

public class Student {
	// fields
	private String   name;
	private String   tel;
	private int      inYear;
		
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public int getInYear() {
		return inYear;
	}
	// Constructor
	public Student() {}
	public Student(String name, String tel, int inYear) {
		this.name = name;
		this.tel = tel;
		this.inYear = inYear;
	}
	
	@Override
	public String toString() {
		String msg = "이름:" + this.name;
		msg += ", 전화:"     + this.tel;
		msg += ", 입학연도:"  + this.inYear;
		return msg;
	}
	
	
}
