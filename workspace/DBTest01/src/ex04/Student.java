package ex04;

public class Student {
	private  int      stnum;
	private  String   stname;
	private  String   tel;
	private  String   indate;
	
	public Student(int stnum, String stname, String tel, String indate) {
		this.stnum = stnum;
		this.stname = stname;
		this.tel = tel;
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "Student [stnum=" + stnum + ", stname=" + stname + ", tel=" + tel + ", indate=" + indate + "]";
	}
	
	
	
}
