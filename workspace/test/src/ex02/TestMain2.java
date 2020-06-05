package ex02;

public class TestMain2 {
	public static void main(String[] args) {
		//객체 배열을 사용할 준비
		Student[] stds = new Student[5];
		
		stds[0] = new Student(1,"길동",54);
		stds[1] = new Student(2,"꺽정",84);
		stds[2] = new Student(3,"홍길",100);
//		stds[3] = new Student(4,"길이",100);
//		stds[4] = new Student(5,"마이",100);
		
		Students st = new Students();
		st.output(stds);
	}
}
