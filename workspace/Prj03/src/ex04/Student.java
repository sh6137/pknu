package ex04;

public class Student {
	//Fields
	private int num;
	private String name;
	private int kor,eng,mat;
	
	//getter // setter
	
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
	
	public int getKor() {
		return kor;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public int getEng() {
		return eng;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getMat() {
		return mat;
	}
	
	public void setMat(int mat) {
		this.mat = mat;
	}
	//Constructor
	public Student() {
		
	}
	

	public Student(int num, String name, int kor, int eng, int mat) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	//Methods
	public int getTot() {
		int tot = this.kor +this.eng + this.mat;
		return tot;
		
	}
	public int getAvg() {
		int avg = (this.kor +this.eng + this.mat)/3;
		return avg;
		
	}
	public char getGrade() {
		char[]grd = {'F','F','F','F','F','F','D','C','B','A','A'};
		return grd[getAvg()/10];
	}
	
	public void dispScores() {
		System.out.printf(
				"번호 :%d 이름 :%s 국어 : %d 영어 :%d 수학 :%d 총점 :%d 평균 %d 학점 %c",
				this.num,this.name,this.kor,this.eng,this.mat,getTot(),getAvg(),getGrade());
	}
}
