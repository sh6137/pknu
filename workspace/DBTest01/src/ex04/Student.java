package ex04;

public class Student {
	private int		stnum;
	private String	stname;
	private String	tel;
	private String	indate;
	
	
	
	public Student(int stnum, String stname, String tel, String indate) {
		this.stnum = stnum;
		this.stname = stname;
		this.tel = tel;
		this.indate = indate;
	}
	public int getStnum() {
		return stnum;
	}
	public void setStnum(int stnum) {
		this.stnum = stnum;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	
	@Override
	public String toString() {
		return "Student [stnum=" + stnum + ", stname=" + stname + ", tel=" + tel + ", indate=" + indate + "]";
	}
	
	
	
}
