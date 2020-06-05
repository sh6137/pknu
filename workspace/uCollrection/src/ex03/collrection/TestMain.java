package ex03.collrection;

import java.util.ArrayList;

class Car{
	
}

public class TestMain {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40.7);
		al.add(55);
		al.add("고길동");
		
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		al.add(new Car());
		
		Car myCar = (Car) al.get(6);
		System.out.println("-------------");
		//Generic 버전 자바 5 기능 1.5
		ArrayList<String> names = new ArrayList<String>();
		names.add("정연");
		names.add("쯔위");
		names.add("사나");
		names.add("모모");
		names.add("다연");
		names.add("정연");
		
		ListDisplay(names);
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		names.remove(3);
		System.out.println("-------------");
		System.out.println("요소 삭제후 출력");
//		for (int i = 0; i < names.size(); i++) {
//			System.out.println(names.get(i));
//		}
		ListDisplay(names);
		names.add("나연");
		names.add("혜리");
		names.remove("혜리");
		System.out.println("-------------");
		System.out.println("요소 추가후 출력");
//		for (int i = 0; i < names.size(); i++) {
//			System.out.println(names.get(i));
//		}
		ListDisplay(names);
		
	}

	private static void ListDisplay(ArrayList<String> names) {
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println("ArrayList " + i +" , "+ names.get(i));
		}
	}
}
