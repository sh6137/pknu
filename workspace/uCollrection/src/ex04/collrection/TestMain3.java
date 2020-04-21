package ex04.collrection;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

//Vector 는 ArrayList 의 Thread Safe 버전
public class TestMain3 {
	
	public static void main(String[] args) {
		List<Board> list = new Vector<Board>();
		
		System.out.println("자료없음 : " + list.isEmpty());
		
		list.add(new Board(1,"제목1","내용1"));
		list.add(new Board(2,"제목2","내용12"));
		list.add(new Board(3,"제목3","내용123"));
		list.add(new Board(4,"제목4","내용1234"));
		list.add(new Board(5,"제목5","내용12345"));
		list.add(new Board(6,"제목6","내용123456"));
	
		System.out.println("자료없음 : " + list.isEmpty());
		System.out.println("자료수 : " + list.size());
		display(list);
		
		list.remove(2);
		display(list);
		
		System.out.println("초기화");
		list.clear();
		System.out.println("자료없음 : " + list.isEmpty());
	}
	
	private static void display(List<Board> list) {
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		System.out.println("=====");
		for (Board board : list) {
			System.out.println(board);
			System.out.println(board.toString());
		}
		
	}
}
