package ex04;

public class TestMain {
	public static void main(String[] args) {
		Student student = new Student(1,"쯔위",100,100,100);
		student.dispScores();
		
		System.out.println(student.getName());
		
		student.setMat(80);
		
		System.out.println(student.getMat());
		
		System.out.println();
		System.out.println(student);
		System.out.println(student.toString());
		System.out.println(student.hashCode());
		
		Student student2 = new Student(1,"나연",100,100,100);
		System.out.println(student2.toString());
		
	}
}
