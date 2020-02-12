package ex03;

public class Method {
	/* 함수 : function
		-> method: 클래스 안에 있는 함수
		main():프로그램의 시작점과 끝 점을 결정
	*/
	public static void main(String[] args) {
		input();
		precess();
		output();
	}

	private static void output() {
		
		System.out.println("데이터를 출력한다.");
	}

	private static void precess() {
		
		System.out.println("계산한다.");
		
	}

	private static void input() {
		System.out.println("입력한다.");
		
	}

	
}
