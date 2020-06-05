package com.pknu.member.vo;

public class MemberVO {
	// Fields
	private String  id;
	private String  pwd;
	private String  name;
	private String  job;
	private String  gender;
	private String  intro;
	private String  regdate;
	
	// Constructor
	public MemberVO(String id, String pwd, String name, String job, String gender, String intro, String regdate) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.job = job;
		this.gender = gender;
		this.intro = intro;
		this.regdate = regdate;
	}

	public MemberVO(String[] cols) {
		this.id      = cols[0];
		this.pwd     = cols[1];
		this.name    = cols[2];
		this.job     = cols[3];
		this.gender  = cols[4];
		this.intro   = cols[5];
		this.regdate = cols[6];
	}

	public MemberVO(String id, String pwd, String name, String job, String gender, String intro) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.job = job;
		this.gender = gender;
		this.intro = intro;	
	}

	// Getter Setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	// toSting
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", job=" + job + ", gender=" + gender
				+ ", intro=" + intro + ", regdate=" + regdate + "]";
	}

	// method
	public String info() {
		String  fmt        =  "%s %s %s %s %s %s %s";		
		String  genderKor  =  "";
		
		switch( gender) {
		case "M": genderKor =  "남자";     break;
		case "F": genderKor =  "여자";     break;
		default : genderKor =  "성별모름";
		}
		//         012345678901234567890
		// regdate 2020-05-28 09:51:03
		String  rdate  =  regdate.substring(0, 10);
		String  msg  =  String.format(fmt, 
				id,  pwd,  name, job, genderKor, intro, rdate);
		return  msg;
	}

	public String  listInfo() {
		String  fmt  =  "%s %s %s %s %s %s %s";
		String  msg  =  String.format(fmt, 
				id,  pwd,  name, job, gender, intro, regdate);
		return  msg;
	}

	
	
}
