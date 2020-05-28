package preparedstatement1;

public class Member {
	//Fileds
	private int mid;
	private String name;
	private String email;
	private String phone;
	private String mlevel;
	private int point;
	private String rdate;
	
	//Constructor
	public Member() {
		
	}
	
	public Member(int mid, String name, String email, String phone, String mlevel, int point, String rdate) {
		super();
		this.mid = mid;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.mlevel = mlevel;
		this.point = point;
		this.rdate = rdate;
	}
	
	public Member(int mid, String name, String email, String mlevel) {
		this.mid = mid;
		this.name = name;
		this.email = email;
		this.mlevel = mlevel;
	}
	//insert
	public Member(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	//생성자 update
	public Member(int mid, String name, String email, String phone, int point) {
		this.mid = mid;
		this.name = name;
		this.phone = phone;
		this.point = point;
		this.email = email;
	}

	public Member(int mid) {
		this.mid = mid;
		}

	//getter
	public int getMid() {
		return mid;
	}
	
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMlevel() {
		return mlevel;
	}

	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	//toString()
	
	@Override
	public String toString() {
		return "Member [mid=" + mid + ", name=" + name + ", email=" + email + ", phone=" + phone + ", mlevel=" + mlevel
				+ ", point=" + point + ", rdate=" + rdate + "]";
	}
	

	public String listInfo() {
		
		String fmt = "%d %s %s %s";
		String msg = String.format(fmt, mid,name,email,mlevel);
		return msg;
	}

}
