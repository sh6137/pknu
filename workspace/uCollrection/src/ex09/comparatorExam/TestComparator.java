package ex09.comparatorExam;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Fruit{
	 String name;
	 int price;
	
	public Fruit(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
}
//중복없이 내림차순 정렬
class DescendingComparator implements Comparator<Fruit>{

	@Override
	public int compare(Fruit o1, Fruit o2) {
		// TODO Auto-generated method stub
		//return o1.price - o2.price; //내림차순
		return o2.price - o1.price; //오름차순
		
	}
	
}


class DescendingComparatorByName implements Comparator<Fruit>{

	@Override
	public int compare(Fruit o1, Fruit o2) {
		
		return o1.name.compareTo(o2.name);
	}


	
}


public class TestComparator {
	public static void main(String[] args) {
		//TreeSet<Fruit> treeSet = new TreeSet<Fruit>(); //error
		TreeSet<Fruit> treeSet = 
				new TreeSet<Fruit>(new DescendingComparator()); //가격순
		
		TreeSet<Fruit> treeSet2 = 
				new TreeSet<Fruit>(new DescendingComparatorByName()); //이름순
		
		
		
		treeSet2.add(new Fruit("포도", 3000));
		treeSet2.add(new Fruit("수박", 10000));
		treeSet2.add(new Fruit("딸기", 6000));
		treeSet2.add(new Fruit("오렌지", 16000));
		treeSet2.add(new Fruit("망고", 1000));
		
		System.out.println(treeSet2.size());
		
		Iterator<Fruit> iter = treeSet2.iterator();
		while (iter.hasNext()) {
			Fruit fruit = iter.next();
			System.out.println(fruit.name + ", " + fruit.price);
			
		}
	}

}
