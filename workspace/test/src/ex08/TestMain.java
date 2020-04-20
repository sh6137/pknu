package ex08;
// 익명클래스 : Anonymous class 클래스이름 없음
interface Command{
	void execute();
}

class CommandProcess{
	public void process(Command command) {
		command.execute();
	}
}

public class TestMain {
	public static void main(String[] args) {
		CommandProcess cp = new CommandProcess();
		cp.process(new Command() {
			
			@Override
			public void execute() {
				System.out.println("내용보기 실행");
			}
		});
	}
}
