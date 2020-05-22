package member;

import java.util.Vector;

//{"sky1","blue1","파란1",1993}
public class MemberVO {
	private String userId;
	private String passuserPwd;
	private String username;
	private int birthYear;
	
	public MemberVO(String userId, String passuserPwd, String username, int birthYear) {
		super();
		this.userId = userId;
		this.passuserPwd = passuserPwd;
		this.username = username;
		this.birthYear = birthYear;
	}
	//나이
	public int getAge() {
		int age = 2020 - this.birthYear +1;
		return age;
		
	}
	//성인여부
	public String getAdult() {
		String result = (this.getAge() >= 20) ? "성인" : "미성년자";
		return result;
	}
	public Vector getVector() {
		Vector v = new Vector();
		v.add(this.userId);
		v.add(this.passuserPwd);
		v.add(this.username);
		v.add(this.birthYear);
		v.add(this.getAge());
		v.add(this.getAdult());
		
		return v;
	}
	
}
