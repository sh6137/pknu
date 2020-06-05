package ex11;

public class TestMain4 {
	public static void main(String[] args) {
		Student []studs = new Student[5];
		studs[0] = new Student("가연","010-1234-1111",100);
		studs[1] = new Student("나연","010-1234-2222",80);
		studs[2] = new Student("다연","010-1234-3333",90);
		studs[3] = new Student("라연","010-1234-4444",100);
		studs[4] = new Student("마연","010-1234-5555",60);
		
		studends_info(studs);
		
		Student []studs2 = new Student[]{
			new Student("가연","010-1234-1111",100),
			new Student("나연","010-1234-2222",80),
			new Student("다연","010-1234-3333",90),
			new Student("라연","010-1234-4444",100),
			new Student("마연","010-1234-5555",60),
		};
		
		Student []studs3 = {
				new Student("가연","010-1234-1111",100),
				new Student("나연","010-1234-2222",80),
				new Student("다연","010-1234-3333",90),
				new Student("라연","010-1234-4444",100),
				new Student("마연","010-1234-5555",60),
			};
		
		
	}

	private static void studends_info(Student[] studs) {
		for (int i = 0; i < studs.length; i++) {
			System.out.println((i+1)+":");
			studs[i].info();
		}
		
	}
}
