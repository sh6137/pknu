package com.spring.user.vo;

public class UserVo {
	private String userid;
	private String userpass;
	private String username;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public UserVo(String userid, String userpass, String username) {
		super();
		this.userid = userid;
		this.userpass = userpass;
		this.username = username;
	}
	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", userpass=" + userpass + ", username=" + username + "]";
	}
	
	
	
	
}
