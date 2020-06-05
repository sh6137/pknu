package ex08_1;


public class TextMain {
	public static void main(String[] args) {
		Student[] std = new Student[5];
		
		std[0] = new Student(0,"쯔위",80,70 ,100);
		std[1] = new Student(1,"모모",60 ,80 ,90);
		std[2] = new Student(2,"사나",80 ,90 ,70);
		std[3] = new Student(3,"소미",100 ,100 ,100);
		std[4] = new Student(4,"정연",60 ,80 ,70);
		
		Students st = new Students();
		st.output(std);
		
		st.totalScore(std);
		
		st.rank(std);
		
		
		
	}
}
