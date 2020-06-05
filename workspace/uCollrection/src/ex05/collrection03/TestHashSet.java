package ex05.collrection03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet {
	public static void main(String[] args) {
		HashSet<String> set  = new HashSet<String>();
		
		System.out.println(set.size());
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/Jsp");
		set.add("Java"); //중복
		set.add("Mybatis");
		System.out.println(set.size());
		//출력
		setDisplay(set);
		
		System.out.println("****************");
		set.remove("JDBC");
		
		
		setDisplay(set);
		//set.clear();
		set.removeAll(Arrays.asList("Java", "JDBC"));
		setDisplay(set);
		if(set.isEmpty())
			System.out.println("자료 없음");
		
		
	}

	private static void setDisplay(HashSet<String> set) {
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String element = iter.next();
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
