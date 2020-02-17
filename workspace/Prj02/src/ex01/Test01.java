package ex01;

public class Test01 {
	private static int add(int v1, int v2) {
		int val;
		val = v1+v2;
		return val;
	}	
	public static void main(String[] args) {
		int v1, v2;
		int val1;
		
		v1 = 7;
		v2 = 2;
		//val1= v1+v2;
		val1 = add(v1,v2);
		System.out.println(v1+" + "+v2+" = " + val1);
		
		Test01 t1 = new Test01();
		int val2_2 =t1.add(v1, v2);
		System.out.println(v1+" + "+v2+" = " + val1);
	}

}
