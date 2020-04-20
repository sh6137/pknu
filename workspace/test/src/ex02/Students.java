package ex02;

public class Students {
	Student[] students;
	
	//객체 배열 출력
	public void output(Student[] students) {
		
		String msg ="번호 이름 점수  \n";
		for (int i = 0; i < students.length; i++) {
			
			if(students[i] == null)break;
			
			msg += students[i].num + " "
					+ students[i].name + " "
					+ students[i].jumsu + "\n";
			
		}
		System.out.println(msg);
	}
}
