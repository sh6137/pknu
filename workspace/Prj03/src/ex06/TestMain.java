package ex06;

class Student{
	String name;
	String tel;
	
	public void info() {
		System.out.println(name + ":" + tel);
	}
	//equals 는 기능 재정의가 아니면 hashcode 비교
	//String euqals 는 값을 비교하도록 재정의 되어있다.
	//기존의 equals 기능을수정(재정의)
	//@override : @:annotation약자 :컴파일러에게 정보를 준다.
	//혹시 오타가 발생하여 다른 메소르도 인식하지 않도록
	@Override
	public boolean equals(Object obj) {
		boolean isSameName = false;
		boolean isSameTel = false;
		
		Student other = (Student)obj;
		isSameName = this.name.equals(other.name);
		isSameTel = this.tel.equals(other.tel);
		
		return isSameName && isSameTel;
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
		
		
	//	euqals()를 재정의 하기전은 다른
	//	재정의 한 후 는 같은
		if(s1.equals(s3)) {
			System.out.println("같은");
		}
		else {
			System.out.println("다른");
		}
	}
}
