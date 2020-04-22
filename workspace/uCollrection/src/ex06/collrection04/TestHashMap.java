package ex06.collrection04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashMap {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("쯔위", 100);
		map.put("아이유", 90);
		map.put("소영", 95);
		map.put("수영", 93);
		
		System.out.println(map.size());
		System.out.println("소영 : " + map.get("소영"));
		
		map.put("소영", 100); //data 변경, .set() 역할
		System.out.println(map.size());
		System.out.println("소영 : " + map.get("소영"));
		
		//1. 객체를 하나씩 처리 : keySet
		
		System.out.println("--------------------------------");
		Set<String> keySet = map.keySet();
		Iterator<String> iter = keySet.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			Integer value = map.get(key);
			System.out.println(key + " : " + value);
		}
		
		//-----------------------------------------------------------
		
		map.remove("아이유");
		System.out.println(map.size());
		
		//2.객체를 하나씩 처리 : MapEntry
		System.out.println("--------------------------------");
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIter = entrySet.iterator();
		while (entryIter.hasNext()) {
			Map.Entry<String, Integer> entry = entryIter.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + ", " + value);
		}
		map.clear();
		if(map.isEmpty())
			System.out.println("자료가 없습니다.");
		
		
	}
}
