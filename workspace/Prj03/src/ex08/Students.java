package ex08;

public class Students {
	Student[] students;

	
	
	public Students(Student[] students) {
		this.students = students;
	}


	public Students() {
		// TODO Auto-generated constructor stub
	}


	public void output() {
		String msg ="";
		for (int i = 0; i < students.length; i++) {
			msg+= students[i].num + ","
					+students[i].name + ","
					+students[i].jumsu +"\n";
		}
		System.out.println(msg);
	}
	
	public void output(Student[] students) {
		String msg ="";
		for (int i = 0; i < students.length; i++) {
			msg+= students[i].num + ","
					+students[i].name + ","
					+students[i].jumsu +"\n";
		}
		System.out.println(msg);
	}
	
}
