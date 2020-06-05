package ex06;

import java.io.UnsupportedEncodingException;
import java.util.Date;


public class Text03 {
	public static void main(String[] args) {
		// 네트워크 통신 프로그램에 사용한다. 
		//문자배열 -> 문자열로 변환
		byte []bytes = {'H','e','l','l','o',' ','j','a','v','a'};
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes,6,4); //시작위치 , 갯수
		System.out.println(str2);
		
		System.out.println("======================");
		//getByte() = String -> byte[]
		String str3 = "안녕하세요";
		byte []byte3 = str3.getBytes();
		System.out.println(byte3.length);
		
		for(int i = 0; i < byte3.length;i++) {
			System.out.printf("%d ", byte3[i]);
			
			System.out.printf("%x ", byte3[i]);
			System.out.println();
		}
		
		// 네트워크 통신 프로그램에 사용한다. 
		
		/*    -------------            */
		// encoding 변환

		try {
			byte[] byteEUCKR = str3.getBytes("EUC-KR");
			System.out.println(byteEUCKR);
			
			String strEUCKR = new String(byteEUCKR , "EUC-KR");
			System.out.println(strEUCKR);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*------------------------------------------*/
		
		//대소문자 변환
		
		String sc1 = "Text Editer v1.8";
		System.out.println(sc1.toUpperCase());
		System.out.println(sc1.toLowerCase());
		System.out.println(sc1.trim()); // 앞뒤공백제거
		
		//문자열 밍부 추출
		String sc2 = "901225-1111114";
		String yy = sc2.substring(0,2);
		String mm = sc2.substring(2,4);
		String dd = sc2.substring(0,2);
		String sex = sc2.substring(7,8);
		String gender = null;
		if(sex.equals("1") || sex.equals("3") || sex.equals("5")
				|| sex.equals("7") ||sex.equals("9")) {
			gender = "남자";
			
		}
		if(sex.equals("0") || sex.equals("2") || sex.equals("4")
				|| sex.equals("6") ||sex.equals("8")) {
			gender = "여자";
		}
		
		String bYear = (sex == "3" || sex == "4") ? "20" + yy : "19" + yy;
		System.out.println("태어난 연도 : " + sc2.substring(0,2));
		System.out.println("태어난 월 : " + sc2.substring(2,4));
		System.out.println("태어난 일 : " + sc2.substring(4,6));
		System.out.println("태어난 성별 : " + sc2.substring(7,8));
		
		int y = Integer.valueOf(yy);
		int m = Integer.valueOf(mm);
		int d = Integer.valueOf(dd);
		Date oneday = new Date(y,m-1,d, 11,20,30); //(90,11,25)
		System.out.println(oneday.toLocaleString());
		int wkday = oneday.getDay(); //요일
		System.out.println(wkday); //2 = 화요일
		
		String []wk = {"日","月","火","水","木","金","土"};
		
		String format = "%4d年년%2d月월%2d日일 %s요일";
		String msg = String.format(format, y,m,d,wk[wkday]);
		System.out.println(msg);
		
		//leading 0 35 -> 0035
		String ss1 = "354567-1234568";
		String ss2 = (String)ss1.subSequence(0, 6);
		System.out.println(ss2);
		
		//세자리 마다 , 출력
		
		//~로 시작하는
		String name1 = "김유신";
		System.out.println(name1);
		System.out.println(name1.startsWith("김"));
		//~로 끝나는
		String name2 = "이순신";
		System.out.println(name1.endsWith("김"));
		//문자열을 문자배열로
		String string = "abcdefghijklmnopqrs";
		char[]charArr = string.toCharArray();
		for(int i=0; i< charArr.length;i++) {
			System.out.println(i+":" + charArr[i]);
		}
		//문자열을 token 으로 분이하여 문자배열로
		String str = "1,김일,부산,27";
		String[] s = str.split(",");
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
		
	}
}
