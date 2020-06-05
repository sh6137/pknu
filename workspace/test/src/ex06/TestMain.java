package ex06;

//메소드가 abstract 인 경우 사용
interface Printable{
	void print(String doc);
}

class SamsungPrinterDriver implements Printable{

	@Override
	public void print(String doc) {
		System.out.println("삼성 프린터 입니다.");
		System.out.println(doc);
	}
	
}

class LGPrintDriver implements Printable{

	@Override
	public void print(String doc) {
		System.out.println("LG 프린터 입니다.");
		System.out.println(doc);
	}
	
}

class PDFfile implements Printable{

	@Override
	public void print(String doc) {
		
		System.out.println("PDF 파일 생성");
		System.out.println(doc);
	}
	
}

public class TestMain {
	public static void main(String[] args) {
		Printable prn1 = new SamsungPrinterDriver();
		prn1.print("HELLO 프린터");
		
		Printable prn2 = new LGPrintDriver();
		prn2.print("HELLO 프린터");
		
		prn2 = new SamsungPrinterDriver();
		prn2.print("인쇄데이터");
		
		Printable prn3 = new PDFfile();
		prn3.print("생성");
		}
}
