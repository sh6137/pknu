package ex08_1;

public class Student {
	int num;
	String name;
	int kor;
	int eng;
	int math;
	int tot;
	int avg;
	String score;
	
	public Student() {
		
	}
	
	public Student(int num, String name, int kor, int eng, int math) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot = methodTot();
		this.avg = methodAvg();
		this.score = this.methodScore();
	}
	
	public int methodTot() {
		this.tot = kor+eng+math;
		return tot;
	}
	
	public int methodAvg() {
		this.avg = (kor+eng+math)/3;
		return avg;
	}
	
	public String methodScore() {
		if(avg /10 == 10) {
			score = "A";
		}
		else if(avg /10 ==9) {
			score = "B";
		}
		else if(avg /10 ==8) {
			score = "C";
		}
		else if(avg /10 ==7) {
			score = "D";
		}
		else {
			score = "F";
		}
		return score;
	}
	
	
}
