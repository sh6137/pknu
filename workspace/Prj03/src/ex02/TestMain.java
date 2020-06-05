package ex02;

class Student{
	int num;
	String name;
	int kor, eng, mat;
	
}


public class TestMain {
	public static void main(String[] args) {
	
		Student s01 = new Student();
		
		s01.num =1;
		s01.name = "아이유";
		s01.eng = 100;
		s01.kor = 100;
		s01.mat = 100;
		
		int tot = s01.eng + s01.kor + s01.mat;
		int avg = (s01.eng + s01.kor + s01.mat) / 3;
		System.out.println("번호 이름 총점 평균");
		System.out.printf("%3d %4s %3d %3d\n",
				s01.num, s01.name, tot, avg);
		
	}
}
