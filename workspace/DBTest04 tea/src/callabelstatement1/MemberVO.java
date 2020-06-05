package callabelstatement1;

// DTO  : data transfer Object -> 과거
// VO   : Value Object
public class MemberVO {
	// 필드
	private String	memid;
	private String	mname;
	private String	email;
	private String	passwd;
	private String	phone;
	private String	regdate;
	private int   	mpoint;
	private String  mlevel;
	
	// 생성자
	public MemberVO() {}
	
    // 생성자 : getmember
	public MemberVO(String memid, String mname, String email, String passwd,
			String phone, String regdate, int mpoint, String mlevel) {
		this.memid   = memid;
		this.mname   = mname;
		this.email   = email;
		this.passwd  = passwd;
		this.phone   = phone;
		this.regdate = regdate;
		this.mpoint  = mpoint;
		this.mlevel  = mlevel;
	}
	
	// 셍성자 : insert
	public 	MemberVO(String memid, String mname, 
			String  email, String passwd, String phone) {
		this.memid   = memid;
		this.mname   = mname;
		this.email   = email;
		this.passwd  = passwd;
		this.phone   = phone;	
	}
	

	public MemberVO(String memid, String mname, String email,
			String phone, String regdate, String mlevel) {
		this.memid     = memid;
		this.mname     = mname;
		this.email     = email;
		this.phone     = phone;
		this.regdate   = regdate;
		this.mlevel    = mlevel;
	}

	public String getMlevel() {
		return mlevel;
	}

	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}

	// Getter / Setter
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getMpoint() {
		return mpoint;
	}
	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}


	public String info() {
		String   fmt  = "%s %s %s %s %s %s %s(%d) ";
		String   msg  = String.format(fmt,
				memid, mname, email, passwd, phone, regdate, mlevel, mpoint);
		return   msg;
	}

	public String listInfo() {
		String   fmt  = "%s %s %s %s %s %s ";
		String   msg  = String.format(fmt,
				memid, mname, email, phone, regdate, mlevel);
		return   msg;
	}
	
	
	
	// toStirng override
	@Override
	public String toString() {
		return "MemberVO [memid=" + memid + ", mname=" + mname + ", email=" + email + ", passwd=" + passwd + ", phone="
				+ phone + ", regdate=" + regdate + ", mpoint=" + mpoint + ", mlevel=" + mlevel + "]";
	}

	
	
}
