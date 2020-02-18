package ex01;

public class TestMain {
	//성적처리
	public static void main(String[] args) {
		int num =01;
		String name = "홍길동";
		int kor =100 , eng=100, mat =100;
		
		int tot1 = sum(kor, eng, mat);
		int avg1 = avg(kor, eng, mat);
	
		System.out.printf("번호:%d 이름:%s 총점:%s 평균:%d\n",num,name,tot1,avg1);
		
		num =02;
		name = "임꺽정";
		kor =100;
		eng=100; 
		mat =100;
		
		tot1 = sum(kor, eng, mat);
		avg1 = avg(kor, eng, mat);
	
		System.out.printf("번호:%d 이름:%s 총점:%s 평균:%d\n",num,name,tot1,avg1);
		num =03;
		name = "고길동";
		kor =100;
		eng=100; 
		mat =100;
		
		tot1 = sum(kor, eng, mat);
		avg1 = avg(kor, eng, mat);
	
		System.out.printf("번호:%d 이름:%s 총점:%s 평균:%d\n",num,name,tot1,avg1);
	}

	private static int avg(int kor, int eng, int mat) {
		int avg1 = (int)(((kor+eng+mat)/3.0) +0.5);
		return avg1;
	}

	private static int sum(int kor, int eng, int mat) {
		int tot1 = kor + eng + mat;
		return tot1;
	}
}
