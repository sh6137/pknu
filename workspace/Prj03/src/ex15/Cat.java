package ex15;


public class Cat implements IPet {
	
	String name;
	@Override
	public void cry() {
		System.out.println(name + "야옹");
		
	}

}
