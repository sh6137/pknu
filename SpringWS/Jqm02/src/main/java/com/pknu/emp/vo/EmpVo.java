package com.pknu.emp.vo;

public class EmpVo {
	// Fields 
	private  int     idx;
	private  String  title;
	private  String  name;
	private  String  regdate;
	
	// Getter / Setter
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	//toString()
	@Override
	public String toString() {
		return "EmpVo [idx=" + idx + ", title=" + title + ", name=" + name + ", regdate=" + regdate + "]";
	}
	
	
	
}
