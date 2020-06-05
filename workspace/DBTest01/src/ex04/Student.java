package ex04;

public class Student {
<<<<<<< HEAD
	private int		stnum;
	private String	stname;
	private String	tel;
	private String	indate;
	
	
=======
	private  int      stnum;
	private  String   stname;
	private  String   tel;
	private  String   indate;
>>>>>>> 41c882846d9359085f78a3d8cad0e677e64ea61c
	
	public Student(int stnum, String stname, String tel, String indate) {
		this.stnum = stnum;
		this.stname = stname;
		this.tel = tel;
		this.indate = indate;
	}
<<<<<<< HEAD
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
	
=======

>>>>>>> 41c882846d9359085f78a3d8cad0e677e64ea61c
	@Override
	public String toString() {
		return "Student [stnum=" + stnum + ", stname=" + stname + ", tel=" + tel + ", indate=" + indate + "]";
	}
	
	
	
}
