package com.spring.board.vo;

public class BoardVo {
	
	// Fields
	private   int      num;
	private   String   name;
	private   String   email;
	
	// Getter / Setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	
	// 생성자
	public BoardVo() {}   // 기본생성자 필수 생성
	
	public BoardVo(int num, String name, String email) {
		this.num = num;
		this.name = name;
		this.email = email;
	}
	
	// toString
	@Override
	public String toString() {
		return "BoardVo [num=" + num + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
}
