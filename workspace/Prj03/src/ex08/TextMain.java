package ex08;

public class TextMain {
	public static void main(String[] args) {
		Student [] studs = new Student[5];
		studs[0] = new Student(1,"쯔위",100);
		studs[1] = new Student(2,"모모",90);
		studs[2] = new Student(3,"사나",80);
		studs[3] = new Student(4,"소미",70);
		studs[4] = new Student(5,"정연",60);
		
	
		Students st = new Students();
		st.output(studs);
		
		Students st2 = new Students(studs);
		st2.output(studs);
		
	}
}
