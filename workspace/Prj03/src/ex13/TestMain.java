package ex13;

public class TestMain {
	public static void main(String[] args) {
		String name1 = "이순신";
		String name2 = "d순신";
		
		int result = name1.compareTo(name2);
		System.out.println(result);
		
		System.out.println("/*-----------------------*/");
		
		int []nums = {8,9,3,5,7};
		CustomSort.display(nums);
		CustomSort.bubble_sort(nums);
		CustomSort.display(nums);
		
		System.out.println("/*-----------------------*/");
		
		String [] names = {"나연","다연","차연","사연","가연"};
		
		CustomSort.display(names);
		CustomSort.bubble_sort(names);
		CustomSort.display(names);
		
		System.out.println("/*-----------------------*/");
		Student [] studs = new Student[] {
			new Student("이순신", "010-1111-1234",1500),
			new Student("김유신", "010-1111-2222",1600),
			new Student("아이유", "010-3333-4000",1800),
			new Student("에일리", "010-5555-1234",1700),
			new Student("홍진경", "010-7777-1234",1900),
		};
		CustomSort.display(studs);
		CustomSort.bubble_sort(studs ,1);
		CustomSort.display(studs);
		System.out.println();
		CustomSort.bubble_sort(studs ,2);
		CustomSort.display(studs);
		System.out.println();
		CustomSort.bubble_sort(studs ,3);
		CustomSort.display(studs);
		
		
		
	}
}
