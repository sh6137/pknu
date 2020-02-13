package ex05;

public class Test01 {
	public static void main(String[] args) {
		int birthYear = 1993;
		String ddi = "";
		
		ddi = getDdi(birthYear);
		
		System.out.println(ddi + "띠");

		ddi = getDdi2(birthYear);
		System.out.println(ddi + "띠");
		
	}
	
	private static String getDdi2(int birthYear) {
		String ddi = null;
		String[] d = new String[] {
				"원숭이","닭","개",   "돼지",
				"쥐",   "소","호랑이","토끼" ,
				"용",   "뱀," ,"말"  ,"양"
		};
		ddi = d[birthYear % 12];
		return ddi;
	}

	private static String getDdi(int birthYear){
	String ddi="";
	switch (birthYear %12) {
	case 0:
		ddi = "원숭이";			break;
	case 1:
		ddi = "닭";			break;
	case 2:
		ddi = "개";			break;
	case 3:
		ddi = "돼지";			break;
	case 4:
		ddi = "쥐";			break;
	case 5:
		ddi = "소";			break;
	case 6:
		ddi = "호랑이";			break;
	case 7:
		ddi = "토끼";			break;
	case 8:
		ddi = "용";			break;
	case 9:
		ddi = "뱀";			break;
	case 10:
		ddi = "말";			break;
	case 11:
		ddi = "양";			break;
	default:
		break;
	}
	return ddi;
	
	}
	
	

	
}
