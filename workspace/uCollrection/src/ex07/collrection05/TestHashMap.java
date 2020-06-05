package ex07.collrection05;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<Student, Integer>();
		
		map.put(new Student(1,"홍길동"),95);
		map.put(new Student(2,"홍길순"),90);
		map.put(new Student(1,"홍길동"),95);
		
		System.out.println(map.size());
		
		
	}
}
