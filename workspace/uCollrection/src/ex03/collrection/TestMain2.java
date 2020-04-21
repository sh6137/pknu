package ex03.collrection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMain2 {
	//배열과 arraylist 동시 사용하기
	
	public static void main(String[] args) {
		
		List<String> list1 = Arrays.asList("홍길동","이순신","임꺽정","김유신");

	//	ArrayList<String> list1 = (ArrayList<String>) Arrays.asList("홍길동","이순신","임꺽정","김유신");
		
		//enhance for 항샹된 for each
		for(String name : list1) {
			System.out.print(name + " ");
		}
		System.out.println();
		
		List<Integer> list2 = Arrays.asList(13,5,7,9,6);
		
		for (Integer num : list2) {
			System.out.println(num + "");
		}
		
	}
}
