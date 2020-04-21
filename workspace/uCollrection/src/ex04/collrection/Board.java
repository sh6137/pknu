package ex04.collrection;

public class Board {
	private int bnum;
	private String subject;
	private String content;
	
	
	public Board(int bnum, String subject, String content) {
		
		this.bnum = bnum;
		this.subject = subject;
		this.content = content;
	}
	


	@Override
	public String toString() {
		return "Board [bnum=" + bnum + ", subject=" + subject + ", content=" + content + "]";
	}



	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
