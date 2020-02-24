package ex06;

import java.util.Scanner;

public class TestMain {
	//입력 1줄 ->출력 1줄
	//입력 data 사번, 이름, 입사일, 월급, 부서번호
	//수령액 : 월급 + 보너스
	//보너스 : 연차에따라 월급의0.5씩 계산한다.
	//부서번호 10:인사, 20:자제 , 30:총무, 40:연구개발 50:서비스
	//출력결과 사번, 이름,월급, 보너스, 수령액, 부서명
	//입사일순으로 직원정보 출력
	//출력결과 사번, 이름 , 입사일, 월급, 보너스 ,수령액, 부서명
	
	//입력 : empId , empName, hireDate, sal, deptId
	//출력 : empId, empName, hireDate, sal, bonus, pay, deptName
	
	//입력데이터 샘플 (6줄)
	/*
100,A,20010101,300.0,10
200,B,20070101,240.0,10
300,C,20070101,240.0,20
400,D,20090101,260.0,30
500,E,20120101,350.0,40
600,F,20170101,195.0,50


	*/
	static final int ROWS=6;
	// 입력용 변수 : empId , empName, hireDate, sal, deptId
	// 출력용 변수: empId, empName, hireDate, sal, bonus, pay, deptName
	static String [] empId;
	static String [] empName;
	static String [] hiredate;
	static double [] sal;
	static String [] deptId;
	
	static double [] bonus;
	static double [] pay;
	static String [] deptName;
	
	//총계
	static double totSal =0;
	static double totBonus =0;
	static double totPay =0;
	//석차
	static int[] rank;
	public static void main(String[] args) {
		input();
		process();
		output();
		
	}

	private static void input() {
		System.out.println("input()=======================");
		init_data();
		//키보드 입력
		Scanner in  = new Scanner(System.in);
		
		System.out.println("사번,이름,입사일,월급,부서번호");
		for (int i = 0; i < ROWS; i++) {
			String line = in.nextLine();
			String [] str = line.split(",");
			empId[i] = str[0].trim();
			empName[i] = str[1].trim();
			hiredate[i] = str[2].trim();
			sal[i] = Double.valueOf(str[3].trim());
			deptId[i] = str[4].trim();
		}			
	}
	
	private static void init_data() {
		//입력
		
		empId = new String[ROWS];
		empName = new String[ROWS];
		hiredate  = new String[ROWS];
		sal = new double[ROWS];
		deptId = new String[ROWS];
	
		//출력
		bonus = new double[ROWS];
		pay = new double[ROWS];
		deptName = new String[ROWS];
		
		rank = new int[ROWS];
	}

	private static void process() {
		System.out.println("process()====================");
		
		for (int i = 0; i < ROWS; i++) {
			int inYear = Integer.valueOf(hiredate[i].substring(0,4)); 
			int years = 2020-inYear;
			bonus[i]= years * (sal[i]*0.5);
			pay[i] = sal[i] + bonus[i];
			
			switch (deptId[i]) {
			case "10": deptName[i] = "인사";break;
			case "20": deptName[i] = "자재";	break;
			case "30": deptName[i] = "총무";	break;
			case "40": deptName[i] = "연구개발";	break;
			case "50": deptName[i] = "서비스";	break;
			default:
				break;
			}
			totSal += sal[i];
			totBonus += bonus[i];
			totPay += pay[i];
		}
		
		//totPay_sort_desc();
		hiredate_sort_asc();
		totPay_ranking();
	}


	private static void totPay_ranking() {
		rank[0] = 1;
		for (int i = 1; i < ROWS; i++) {
			if(pay[i] == pay[i-1]) {
				rank[i] = rank[i-1];
			}
			else
			rank[i] = (i+1);
			
		}
		
	}

	private static void hiredate_sort_asc() {
		int n = ROWS;
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-1-i; j++) {
				if(hiredate[i].compareTo(hiredate[j+1]) >0) {
					exchange(j, j+1);
				}
			}
		}
	}

	private static void totPay_sort_desc() {
		int n = ROWS;
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-1-i; j++) {
				if(pay[i] < pay[j+1]) {
					exchange(j, j+1);
				}
			}
		}
	}

	private static void exchange(int p1,int p2) {
		//배열 p1 <-> p2
		//empId , empName, hireDate, sal, deptId
		//bonus, pay, deptName
		String tempStr = "";
		double tempNum = 0.0;
		tempStr = empId[p1];
		empId[p1] = empId[p2];
		empId[p2] = tempStr;
		
		tempStr = empName[p1];
		empName[p1] = empName[p2];
		empName[p2] = tempStr;
		
		tempStr = hiredate[p1];
		hiredate[p1] = hiredate[p2];
		hiredate[p2] = tempStr;
		
		tempNum = sal[p1];
		sal[p1]= sal[p2];
		sal[p1] = tempNum ;
		
		tempStr = deptId[p1];
		deptId[p1]= deptId[p2];
		deptId[p1] = tempStr ;
		
		tempNum = pay[p1];
		pay[p1]= pay[p2];
		pay[p1] = tempNum ;
		
		tempStr = deptName[p1];
		deptName[p1]= deptName[p2];
		deptName[p1] = tempStr ;
		
	}

	private static void output() {
		System.out.println("output()======================");
		head();
		title();
		
		String msg = "";
		for (int i = 0; i < ROWS; i++) {
			msg += String.format("%s %s %s %.3f %.3f %.3f %s %d\n",
					empId[i], empName[i], hiredate[i], sal[i], bonus[i], pay[i], deptName[i] ,rank[i]);
			
		}
		msg +="월급총계 :" + totSal + "\n";
		msg +="보너스총계 :" + totBonus + "\n";
		msg +="실수령액총계 :" + totPay + "\n";
		System.out.println(msg);
		
	}

	private static void title() {
		System.out.println("사번, 이름 , 입사일, 월급, 보너스 ,수령액, 부서명");
		
		
	}

	private static void head() {
		System.out.println("======================================");
		System.out.println("================월급목록================");
		System.out.println("======================================");
	}
}
