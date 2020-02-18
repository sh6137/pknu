package ex05;

class Student{
	
}


public class TestMain {
	public static void main(String[] args) {
		//String [] args : main 함수의 인자처리
		//명령형 인자처리
		//package exploror 의 Prj03_.ex05->
		//TestMain 의 오른쪽 마우스 버튼 클릭
		//Runas -> Run config...
		for (int i = 0; i < args.length; i++) {
			System.out.println(i+ " : " + args[i]);
		}
		Object obj = new Object();
		System.out.println(obj);
		
		Student s1 = new Student();
		System.out.println(s1);
		Student s2 = new Student();
		System.out.println(s2);
	}
}
