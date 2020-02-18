package ex08_1;


public class TextMain {
	public static void main(String[] args) {
		Student[] std = new Student[5];
		
		std[0] = new Student(1,"쯔위",100,100 ,100);
		std[1] = new Student(2,"모모",100 ,100 ,90);
		std[2] = new Student(3,"사나",80 ,80 ,70);
		std[3] = new Student(4,"소미",70 ,80 ,70);
		std[4] = new Student(5,"정연",60 ,80 ,70);
		
		Students st = new Students();
		st.output(std);
		
		st.totalScore(std);
	}
}
