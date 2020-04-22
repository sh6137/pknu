package ex09.ComparableExam;

import java.util.Iterator;
import java.util.TreeSet;

//TreeSet 에 사용할 객체는 반드시 implements Comparable<Preson> 해야한다.
//implement 하지 않으면
//java.lang.classcastException : 예외발생
//내부적으로 compare() 를 호출한다. compareTo()를 override 해야한다.

//객체를 비교하려면(정렬하기 위해)
//implements Comparable<Person> 하라



class Person implements Comparable<Person>{
	String name;
	int age;
	int num;
	public Person(int num,String name, int age) {
		
		this.num = num;
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		
		return num - o.num;
	}
	
}

public class TestComparable {
	public static void main(String[] args) {
		//TreeSet : 중복하지 않고 tree 저장
		//나이가 같으면 저장하지 말라
		TreeSet<Person> treeSet = new TreeSet<>();
		
		treeSet.add(new Person(1,"홍길동", 45));
		treeSet.add(new Person(2,"홍길순", 25));
		treeSet.add(new Person(3,"박지원", 31));
		treeSet.add(new Person(1,"홍길동", 45));
		treeSet.add(new Person(4,"고길동", 45));
		
		for(Iterator iterator = treeSet.iterator(); iterator.hasNext();) {
			Person person = (Person) iterator.next();
			System.out.println(person.num +"," +person.name + "," + person.age);
		}
	}
}
