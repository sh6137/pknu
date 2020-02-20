package ex01;
interface Command{
	void execute();
}
class CommandProcess{
	public void process(Command command) {
		command.execute();
	}
}
public class TestMain {
	//익명클래스 Anonymous Class
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
