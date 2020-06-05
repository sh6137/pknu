package timeex01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMain {
	//자바 날짜와 시간 처리
	public static void main(String[] args) {
		//자바버전별로 함수다름
		//1.
		Date today = new Date();
		//현재 컴퓨터의 날짜와 시간을 가져온다.
		//new Date() java.util.Date;
		System.out.println(today);
		System.out.println(today.toString());
		System.out.println(today.toLocaleString());
		System.out.println(today.toGMTString());
		
		
		Date today2 = new Date();
		SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy/MM/dd");
	}
}
