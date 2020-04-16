package test;

class Student{
	//data : 데이터
	String name = "";
	int kor, eng, mat;
	int tot, avg;
	
	//오버로드 생성자
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}


	//기본 생성자
	public Student() {
		// TODO Auto-generated constructor stub
	}

	// method  : 기능
	int calcTot(){
		
		this.tot = this.kor + this.eng + this.mat;
		return tot;
	}
	
	int avg() {
		this.avg = this.tot /3;
		return avg;
	}


	
	
	//alt shift s >generate to String() -> 모두선택
	
	@Override
	public String toString() {
		return "이름 : " + name 
				+ "\n국어 : " + kor 
				+ "\n영어 : " + eng 
				+ "\n수학 : " + mat 
				+ "\n총 : " + calcTot() 
				+ "\n평 : " + avg() ;
	}
	
}

public class TestMain {
	
	
	
	public static void main(String[] args) {
		
		
		
		System.out.println("테스트");
		
		Student s1 = new Student();
		Student s2 = new Student("aa", 90, 100, 70);
		s1.name = "아이유";
		s1.kor = 100;
		s1.eng = 90;
		s1.mat = 80;
		
		s1.calcTot();
		s1.avg();
		
		
		//cal
		//int tot, avg;
		//tot = s1.calcTot();
		//avg = tot/3;
		
		System.out.println("이름 : " + s1.name);
		System.out.println("국어 : " +  s1.kor);
		System.out.println("영어 : " +  s1.eng);
		System.out.println("수학 : " +  s1.mat);
		System.out.println("총 : " +  s1.tot);
		System.out.println("평 : " +  s1.avg);
		
		System.out.println(s2.toString());
		
	}
}
