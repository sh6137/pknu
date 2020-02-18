package ex08_1;



public class Students {
	Student[] st;
	
	public Students(Student[] students) {
		this.st = students;
	}


	public Students() {
		// TODO Auto-generated constructor stub
	}


	public void output() {
		String msg ="";
		for (int i = 0; i < st.length; i++) {
			msg+= st[i].num + ","
					+st[i].name + ","
					+st[i].kor + ","
					+st[i].eng + ","
					+st[i].math + ","
					+st[i].tot + ","
					+st[i].avg + ","
					+st[i].score + "," +
					st[i].rank +
					"\n";
		}
		System.out.println(msg);
	}
	
	public void output(Student[] st) {
		String msg ="";
		for (int i = 0; i < st.length; i++) {
			msg+= st[i].num + ","
					+st[i].name + ","
					+st[i].kor + ","
					+st[i].eng + ","
					+st[i].math + ",총점"
					+st[i].tot + ","
					+st[i].avg + ","
					+st[i].score + "," +
					st[i].rank +
					"\n";
		}
		System.out.println(msg);
	}
	
	public void totalScore() {
		String msg = "";
		int totalKor = 0;
		int totalKorAvg = 0;
		for (int i = 0; i < st.length; i++) {
			totalKor += st[i].kor;
		}
		totalKorAvg = totalKor / st.length;
		msg = msg+totalKorAvg;
	}
	
	public void totalScore(Student[] st) {
		String msg = " ";
		int totalKor = 0;
		int totalMath = 0;
		int totalEng = 0;
		int totalKorAvg = 0;
		int totalMathAvg = 0;
		int totalEngAvg = 0;
		for (int i = 0; i < st.length; i++) {
			totalKor += st[i].kor;
			totalMath += st[i].math;
			totalEng += st[i].eng;
		}
		totalKorAvg = totalKor / st.length;
		totalMathAvg = totalMath / st.length;
		totalEngAvg = totalEng / st.length;
		msg = totalKorAvg+msg+totalEngAvg+msg+totalMathAvg;
		System.out.println("반 국 영 수 평균" + msg);
	}
	
	public void rank(Student[] st) {
		int tmp;
		for (int i = 0; i < st.length; i++) {
			
			for (int j = 0; j < st.length; j++) {
				if(st[i].tot<st[j].tot) {
					st[i].rank = st[i].rank +1;
				}
			}
			
//			tmp	= st[min].num;
//			st[min].num= st[i].num;
//			st[i].num = tmp;
			
		}
		for (int i = 0; i < st.length; i++) {
			System.out.println(st[i].rank+1 + "등 : " + st[i].name + " 총점 : " + st[i].tot);
		}
	}
}
