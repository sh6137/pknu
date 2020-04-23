package ex09.ComparableExam;

import java.util.TreeSet;
/*
접근제한자 : access modifier
private : 만든 클래스 안의 전역변수
package : 만든 package(bin 폴더안의 폴더)  -안의 전역변수  - 같은 assebly 안에
protected : 같은 패키지 : 상속받은 관계 안의 전역변수
public : 모든 class 안에서 전역변수
Student.class
Student$InnerClass.class
TestComparble3.class
*
*/
// TreeSet 에 사용되는 class는 반드시 comparable 인터페이스를 implement 해야한다.
// 안하면 ClassCastException 이 발생
class Student implements Comparable<Student>{
	private int num;
	private String name;
	private int age;
	private double celcius;
	
	public Student(int num, String name, int age, double celcius) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.celcius = celcius;
	}
	
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.num -o.num;
	}
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getCelcius() {
		return celcius;
	}
	public void setCelcius(double celcius) {
		this.celcius = celcius;
	}
	
	

	
	
}

public class TestComparable3 {
	public static void main(String[] args) {
		TreeSet<Student> treeSet = new TreeSet<>();
		
		treeSet.add(new Student(1,"aaa",19,36.4));
		treeSet.add(new Student(2,"bbb",19,36.9));
		treeSet.add(new Student(3,"ccc",19,36.2));
		treeSet.add(new Student(1,"ddd",19,35.4));
		
		System.out.println(treeSet.size());
	}
}
