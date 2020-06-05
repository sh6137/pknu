package ex12;
class InstCnt{
	static int instNum = 0;
//	int instNum = 0;
	InstCnt(){
		instNum = instNum+1;
		System.out.println(instNum);
	}
}
public class TestMain {
	public static void main(String[] args) {
		InstCnt ic1 = new InstCnt();
		InstCnt ic2 = new InstCnt();
		InstCnt ic3 = new InstCnt();
	}
}
