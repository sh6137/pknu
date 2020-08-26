package com.pknu.post.vo;

public class PostVo {

	// Fields
	private String  zipcode;
	private String  sido;
	private String  gugun;
	private String  dong;
	private String  bunji;
	private int     seq	;
	
	// Getter /Setter
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getBunji() {
		return bunji;
	}
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}

	// Constructor
	public PostVo() { }
	
	public PostVo(String zipcode, String sido, String gugun, String dong, String bunji, int seq) {
		super();
		this.zipcode = zipcode;
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.bunji = bunji;
		this.seq = seq;
	}
		
	// toString 
	@Override
	public String toString() {
		return "PostVo [zipcode=" + zipcode + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", bunji="
				+ bunji + ", seq=" + seq + "]";
	}
	
	//toJSON
	public String toJSON() {
		String fmt  = "{";
		fmt +=  " \"zipcode\" : \"" + zipcode + "\",  ";
		fmt +=  " \"sido\"    : \"" + sido    + "\",  ";
		fmt +=  " \"gugun\"   : \"" + gugun   + "\",  ";
		fmt +=  " \"dong\"    : \"" + dong    + "\",  ";
		fmt +=  " \"bunji\"   : \"" + bunji   + "\",  ";
		fmt +=  " \"seq\"     : "   + seq              ;
		fmt += "}";
		String json = String.format(fmt, zipcode, sido, gugun, dong ,bunji, seq);   
		return json;
	}
	
}
