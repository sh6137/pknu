package ex05.collrection03;




import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestHashSetObject {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member("홍길동",27));
		set.add(new Member("홍길동",27));
		set.add(new Member("홍길순",27));
		
		System.out.println("자료수 : " + set.size());
		
		set.remove(new Member("홍길순", 27));
		System.out.println("자료수 : " + set.size());
		
		for(Iterator<Member> iterator = set.iterator(); iterator.hasNext();) {
			Member member = (Member) iterator.next();
			System.out.println(member.getName() + "," + member.getAge());
		}
	}
}
