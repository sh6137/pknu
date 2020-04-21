package ex04.collrection;

import java.util.ArrayList;

public class TestMain {
	
	//import : ctrl + shift + o
	public static void main(String[] args) {
		ArrayList<Board> boardList = new ArrayList<Board>();
	
		boardList.add(new Board(1,"제목1","내용1"));
		boardList.add(new Board(2,"제목2","내용12"));
		boardList.add(new Board(3,"제목3","내용123"));
		boardList.add(new Board(4,"제목4","내용1234"));
		boardList.add(new Board(5,"제목5","내용12345"));
		boardList.add(new Board(6,"제목6","내용123456"));
		
		display(boardList);
		
		
	}

	private static void display(ArrayList<Board> boardList) {
		for (int i = 0; i < boardList.size(); i++) {
			System.out.println(boardList.get(i));
		}
		System.out.println("=====");
		for (Board board : boardList) {
			System.out.println(board);
		}
		
	}
}
