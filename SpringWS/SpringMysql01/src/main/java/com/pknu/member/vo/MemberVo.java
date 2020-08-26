package com.pknu.member.vo;

public class MemberVo {

	// Fields
	private  int       id;
	private  String    userid; 
	private  String    username; 
	private  String    userpass; 
	private  String    email; 
	private  String    regdate;
	
	// Getter /Setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	// Constructor
	public MemberVo() {		
	}
	public MemberVo(int id, String userid, String username, String userpass, String email, String regdate) {
		super();
		this.id = id;
		this.userid = userid;
		this.username = username;
		this.userpass = userpass;
		this.email = email;
		this.regdate = regdate;
	}

	// toString
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", userid=" + userid + ", username=" + username + ", userpass=" + userpass
				+ ", email=" + email + ", regdate=" + regdate + "]";
	}

}
