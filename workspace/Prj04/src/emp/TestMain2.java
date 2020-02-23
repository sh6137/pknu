package emp;

import java.util.Calendar;
import java.util.Scanner;

/*	 
 * // 입력자료
사번,  이름, 입사일,   월급, 보너스,부서번호
empid, name, hiredate, sal,  comm,  deptid

//출력자료
//정렬 입사일로 오름차순
//연차 5년마다 추가보너스  sal * 3    
//연봉순서 등수출력 
//부서번호  10:인사 20: 자재 30:총무 40:개발 50:서비스 

사번,  이름, 입사일,   월급, 보너스, 실수령, 부서명,   연차 , 연봉순서
empid, name, hiredate, sal,  comm,   pay,    deptname, years, payrank 
 */

public  class TestMain2 {
	// const int  N = 25;   // deprecated
	final static int N = 5; // 한번만 초기화 할 수 있는 값을 선언
	// 전역변수
		
	// 입력
	static String []  empid;
	static String []  name;
	static String []  hiredate;
	static double []  sal;
	static double []  comm;
	static String []  deptid;
	
	// 출력위한 추가변수
	static double []  pay;
	static String []  deptname;
	static int    []  years;
	static int    []  payrank; 
	
	
	public static void main(String[] args) {		
		System.out.println("input()===============");
		input();
		System.out.println("\n\nprocess()===============");
		process();
		System.out.println("\n\noutput()===============");
		output();
	}

	private static void input() {
		// empid, name, hiredate, sal,  comm,  deptid
		// 부서 10:인사 20: 자재 30:총무 40:개발 50:서비스
		
		init_data();
		
		Scanner in = new Scanner(System.in) ;
				
		System.out.println("데이터를 입력:");
		System.out.println("예)사번,이름,입사일,월급,보너스,부서번호");
		/*
100,King,19900223,300.5,400.0,10 
200,Queen,19950223,200.5,400.0,10 
300,Prince,2000223,300.5,500.0,10 
400,Princess,2000223,300.5,500.0,20
500,Knight,2000223,300.5,500.0,40

		 */ 
		for (int i = 0; i < N; i++) {
			String    inStr = in.nextLine();
			System.out.println(i + ":" + inStr);
			//in.nextLine();
			String [] token = inStr.trim().split(",");
			//System.out.println(token[0]);
			empid[i]        = token[0].trim(); 
			name[i]         = token[1].trim();
			hiredate[i]     = token[2].trim();
			sal[i]          = Double.valueOf(token[3].trim()); //300.5;
			comm[i]         = Double.valueOf(token[4].trim()); //400.0;
			deptid[i]       = token[5].trim();			
		}
		
	}
	
	private static void init_data() {
		// 입력둉
		// empid, name, hiredate, sal,  comm,  deptid
		empid    = new String[N];
		name     = new String[N];
		hiredate = new String[N];
		sal      = new double[N];
		comm     = new double[N];
		deptid   = new String[N];
		
		// 출력용
		// empid, name, hiredate, sal, comm, pay, deptname, years, payrank
		pay       = new double[N];
		deptname  = new String[N];
		years     = new int[N];
		payrank   = new int[N];
		
	}

	private static void process() {
		
		// 데이터 채우기
		for (int i = 0; i < N; i++) {
			pay[i]        =  sal[i] + comm[i];  
			
			String dname  =  "";
			//  10:인사 20: 자재 30:총무 40:개발 50:서비스 
			switch( deptid[i] ) {
			case "10": dname = "인사"; break;
			case "20": dname = "자재"; break;
			case "30": dname = "총무"; break;
			case "40": dname = "개발"; break;
			case "50": dname = "서비스"; break;
			}
			deptname[i]   =  dname;

			Calendar today = Calendar.getInstance();		       
	        int thisYear = today.get(Calendar.YEAR);	     
			int year      =  Integer.valueOf(hiredate[i].substring(0, 4));
			years[i]      =  thisYear - year;
			
			double bonus  =  (sal[i] * 3.0) * years[i];
			pay[i]        =  pay[i] + bonus;
			
			payrank[i]	  =  1; // 석차를 위한 초기값 설정
		}
		
		// 실수령액 중심의 석차구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				if ( pay[i] < pay[j]  ) {
					++payrank[i];
				}
			}
		}
		
		//--------------------------------------
		
	}
	
	private static void output() {
		
		System.out.println("====================================");
		System.out.println("==============사원목록==============");
		System.out.println("====================================");
		
		String msg  = "";
		System.out.println("사번,  이름, 입사일,   월급, 보너스, 실수령, 부서명,   연차 , 연봉순서");
		String fmt  = "%s %s %s %.3f %.3f %.3f %s %d %d\n"; 
		for (int i = 0; i <  N; i++) {			
			msg += String.format(fmt, 
					empid[i], name[i], hiredate[i], sal[i],	comm[i],
					pay[i],   deptname[i], years[i], payrank[i] );
		}
		System.out.println(msg);
		
		System.out.println("부서별정보====================");
		System.out.println(
				"부서번호 부서명 인원수 평균월급 최고월급자 최저월급자");
		msg = "";
		fmt = "%s %s %d %.3f %s %s\n";
		int deptlength = 5;
		for (int row = 0; row < deptlength; row++) {
			
		}
		
	}


}
