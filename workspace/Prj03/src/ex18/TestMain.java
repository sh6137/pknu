package ex18;

interface Printer{
	public void print(String doc);
}
class SamsungPrinter implements Printer{

	@Override
	public void print(String doc) {
		System.out.println("삼성칼라프린터" + doc);
	}
	
}
class HpPrinter implements Printer{

	@Override
	public void print(String doc) {
		System.out.println("HP레이저프린터" + doc);
	}
	
}
class LgPrinter implements Printer{

	@Override
	public void print(String doc) {
		System.out.println("Lg잉크프린터" + doc);
	}
	
}

class SaomiPrint implements Printer{

	@Override
	public void print(String doc) {
		System.out.println("샤오미 잉크프린터" + doc);
	}
	
}
public class TestMain {
	public static void main(String[] args) {
		String doc = "인쇄내용";
		SamsungPrinter sp = new SamsungPrinter();
		
		sp.print(doc);
		
		LgPrinter lp = new LgPrinter();
		lp.print(doc);
		
		SaomiPrint sao = new SaomiPrint();
		
		write(sp,doc);
		write(lp,doc);
		write(sao,doc);
	}

	private static void write(Printer prn, String doc) {
		
		prn.print(doc);
	}
	
	
}
