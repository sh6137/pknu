package emp;

import java.util.Scanner;

/*
empid, name, phone, 입사일(hiredate),담당업무(jobid),월급(sal) 보너스(comm) 상사번호managerid , 부서번호(depid)
//입력자료
사번(empid),이름 (name), 입사일(hiredate),월급(sal) 보너스(comm) 부서번호(depid)

//출력자료
//정렬 입사일로 오름차순
//연차 5년마다 추가 보너스 sal*3
//연봉순서 등수출력
//부서번호 10 : 인사 20 : 자재 30 : 총무 : 40 :개발 50:서비스

사번 이름 입사일 월급 보너스 실수령 부서명 			연차		연봉순위
					pay		deptname	years	payrank
*/




public class TestMain {
	//전역변수
//	static const int N= 25;
	final static int N = 6;
	
	//입력
	static String[] empid;
	static String[] name;
	static String[] hiredate;
	static double[] sal;
	static double[] comm;
	static String[] deptid;
	
	static int num[];
	static int rank[];
	static double avgsal[];
	static double totsal[];
	//출력
	static double[] pay;
	static String[] deptname;
	static int [] years;
	static int [] payrank;
	public static void main(String[] args) {
		
		input();
		process();
		output();
	}
	private static void init_data() {
		//입력용
		empid = new String[N];
		name = new String[N];
		hiredate = new String[N];
		sal = new double[N];
		comm = new double[N];
		deptid = new String[N];
		
		num = new int[5];
		
		avgsal = new double[5];
		totsal = new double[5];
		
		//출력용
		pay = new double[N];
		deptname = new String[N];
		years = new int[N];
		payrank = new int[N];
	}
	
	private static void input() {
		Scanner in = new Scanner(System.in);
		init_data();
		System.out.println("데이터를 입력");
		System.out.println("사번(empid),이름 (name), 입사일(hiredate),월급(sal) 보너스(comm) 부서번호(deptid)");
		
		
		for (int i = 0; i < N; i++) {			
			String inStr = in.nextLine();
			System.out.println();
			String [] token = inStr.split(",");
			
			empid[i] = token[0];
			name[i] = token[1];
			hiredate[i] = token[2];
			sal[i] =Double.valueOf(token[3]); // 300.5;
			comm[i] =Double.valueOf(token[4]);// 400.0;
			deptid[i] = token[5];
			teamName(i);
			System.out.println(empid[i]+ " " + name[i] + " " 
					+ hiredate[i] +" "+ sal[i] +" "+ comm[i] +" "+ deptid[i]);
			teamCount(deptid[i]);
			

//			if(deptid[i].equals("10")) {
//				num[0] = num[0]+1;
//			}else if(deptid[i].equals("20")) {
//				num[1] = num[1]+1;
//			}
//			else if(deptid[i].equals("30")) {
//				num[2] = num[2]+1;
//			}
//			else if(deptid[i].equals("40")) {
//				num[3] = num[3]+1;
//			}
//			else if(deptid[i].equals("50")) {
//				num[4] = num[4]+1;
//			}
//			System.out.println(num[0] +" " +num[1] + " " + num[2]
//								+" " + num[3] + " " +num[4]);
//			
			
		}
		for (int j = 0; j < empid.length; j++) {
			payrank[j] =1;
			for (int k = 0; k < empid.length; k++) {
				if(sal[j] < sal[k]) {
					payrank[j] = payrank[j]+1;
				}
			}
			
		}
		
		for (int i = 0; i < deptid.length; i++) {
			if(deptid[i].equals("10")) {
				totsal[0] = (totsal[0] + sal[i]);
			}
			if(deptid[i].equals("20")) {
				totsal[1] = (totsal[1] + sal[i]);
			}
			if(deptid[i].equals("30")) {
				totsal[2] = (totsal[2] + sal[i]);
			}
			if(deptid[i].equals("40")) {
				totsal[3] = (totsal[3] + sal[i]);
			}
			if(deptid[i].equals("40")) {
				totsal[4] = (totsal[4] + sal[i]);
			}
		}
		for (int i = 0; i < avgsal.length; i++) {
			avgsal[i] = totsal[i]/num[i];
		}
		
	}
	
	private static void teamCount(String deptid) {
		if(deptid.equals("10")) {
			num[0] = num[0]+1;
		}else if(deptid.equals("20")) {
			num[1] = num[1]+1;
		}
		else if(deptid.equals("30")) {
			num[2] = num[2]+1;
		}
		else if(deptid.equals("40")) {
			num[3] = num[3]+1;
		}
		else if(deptid.equals("50")) {
			num[4] = num[4]+1;
		}
		
	}
	private static void output() {
		
		System.out.println("======================");
		System.out.println("사원목록");
		System.out.println("======================");
		String msg="";
		String fmt = "%s %s %s %.3f %.3f %.3f,%s,%d,%d\n";
		System.out.println("사번, 이름, 입사일, 월급, 보너스, 실수령, 부서명, 연차, 연봉순위");
		for (int i = 0; i < N; i++) {
			msg += String.format(fmt, 
					empid[i], name[i], hiredate[i], sal[i],
					comm[i], pay[i], deptname[i], years[i], payrank[i]
					);
				
			}
		System.out.println(msg);	
		
		
		System.out.println("======================");
		System.out.println("사원목록");
		System.out.println("======================");
		System.out.println("부서번호     부서명     인원수      평균월급     최고월급자     최저월급자");	
		for (int j = 0; j < num.length; j++) {
			System.out.println(empid[j] + "        " + deptname[j] + "         " + num[j] + "      " + avgsal[j]);
		}
		
		
		
	}


	private static void process() {
		
	}
	private static void teamName(int i) {
		switch (deptid[i]) {
		case "10":
			deptname[i] = "인사";
			break;
		case "20":
			deptname[i] = "개발";
			break;
		case "30":
			deptname[i] = "영업";
			break;
		case "40":
			deptname[i] = "큐에";
			break;
		case "50":
			deptname[i] = "설비";
			break;
		default:
			break;
		}
		
		
	}

}
