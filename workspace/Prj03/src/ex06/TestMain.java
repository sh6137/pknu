package ex06;

class Student{
	String name;
	String tel;
	
	public void info() {
		System.out.println(name + ":" + tel);
	}
}

public class TestMain {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.name="사나";
		s1.tel="010-1234-1234";
		System.out.println(s1.toString());
		s1.info();
		
		Student s2 = new Student();
		s2.name="정연";
		s2.tel="010-1234-1111";
		s2.info();
		
		Student s3 = new Student();
		s3.name="사나";
		s3.tel="010-1234-1234";
		System.out.println(s3.toString());
		s3.info();
		
		//hashcode 비교 : 메모리 위치
		if(s1 ==s3) {
			System.out.println("같은");
		}
		else {
			System.out.println("다른");
		
		}
		
		
		if(s1.hashCode() == s3.hashCode()) {
			System.out.println("같은");
		}
		else {
			System.out.println("다른");
		}
		
		//값을 비교 이름 전화
	//	boolean isSame = s1.name == s3.name;
		boolean isSame = s1.name.equals(s3.name);
		System.out.println(isSame);
				
	//	boolean isSameTel = s1.tel ==s3.tel;
		boolean isSameTel = s1.tel.equals(s3.tel);
		System.out.println(isSameTel);
		
		if(s1.equals(s3)) {
			System.out.println("같은");
		}
		else {
			System.out.println("다른");
		}
	}
}
