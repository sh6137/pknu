package ex07;

import java.util.Scanner;

public class TestMain {
	//입력 : 
	//부서이름 , 이름 , 월급
	//deptId, empName,sal
	/*
10,A,100
10,B,250
10,C,200
20,D,300
40,E,350
40,F,270
40,G,280
	 */
	//출력 : 부서번호, 부서명, 월급합, 최저월급, 최고월급, 최저월급자, 최고월급자
	//		outDeptId,deptName,sumSal,minSal,maxSal,minSalName,maxSalName
	
	/*
	 	10 인사 		550 100 250 A B
	 	20 자재 		300 300 300 C C
	 	30 총무 		0	0	0
	 	40 연구개발 	620 270 350 F E
	 	50 서비스 		0	0	0
	 	
	 */
	//입력
	//inDeptId, empName,sal
	
	
	final static int ROWS = 7; //입력 자료수
	final static int N = 5; // 부서수
	//입력
	//ROWS 입력자료수만큼
	static String[] inDeptId;
	static String[] empName;
	static double[] sal;
	//출력
	//outDeptId,deptName,sumSal,minSal,maxSal,minSalName,maxSalName
	static String[] outDeptId;
	static String[] deptName;
	static double[] sumSal;
	static double[] minSal;
	static double[] maxSal;
	static String[] minSalName;
	static String[] maxSalName;
	static int[] count;
	static double[] salAvg;
	static double[] salTot;
	public static void main(String[] args) {
		input();
		process();
		output();
	}

	private static void input() {
		inti_data();
		System.out.println("부서번호, 이름, 월급:");
		Scanner in  = new Scanner(System.in);
		for (int i = 0; i < ROWS; i++) {
			
			String line =in.nextLine();
			String [] str = line.split(",");
			
			inDeptId[i] = str[0].trim();
			empName[i] = str[1].trim();
			sal[i] = Double.valueOf(str[2].trim());
		}
	}

	private static void inti_data() {
		//입력
		inDeptId = new String[ROWS];
		empName = new String[ROWS];
		sal = new double[ROWS];
		//출력
		outDeptId = new String[N];
		deptName = new String[N];
		sumSal = new double[N];
		minSal = new double[N];
		maxSal = new double[N];
		minSalName = new String[N];
		maxSalName = new String[N];
		salAvg = new double[N];
		salTot  = new double[N];
		count = new int[ROWS];
		//data 초기화
		outDeptId[0] = "10";
		outDeptId[1] = "20";
		outDeptId[2] = "30";
		outDeptId[3] = "40";
		outDeptId[4] = "50";
		
		deptName[0] = "인사";
		deptName[1] = "자제";
		deptName[2] = "총무";
		deptName[3] = "연구개발";
		deptName[4] = "서비스";
		
		for (int i = 0; i < deptName.length; i++) {
			sumSal[i] = 0.0;
			minSal[i] = 0.0;
			maxSal[i] = 0.0;
			minSalName[i] = "";
			maxSalName[i] = "";
			count[i]=0;
		}
	}

	private static void process() {
		int pos = 0;
		for (int i = 0; i < ROWS; i++) {//입력자료수만큼
			switch (inDeptId[i]) {
			case "10" : pos = 0; count[0]++;break;
			case "20" : pos = 1; count[1]++;break;
			case "30" : pos = 2; count[2]++;break;
			case "40" : pos = 3; count[3]++;break;
			case "50" : pos = 4; count[4]++;break;

			default:
				break;
			}
			
			
			if(sumSal[pos] == 0) {
				minSal[pos] =sal[i];
				minSalName[pos] = empName[i];
				maxSal[pos] =sal[i];
				maxSalName[pos] = empName[i];
			}
			else if(minSal[pos] > sal[i]) {
				minSal[pos] =sal[i];
				minSalName[pos] = empName[i];
				}
			else if(maxSal[pos] < sal[i]) {
				maxSal[pos] =sal[i];
				maxSalName[pos] = empName[i];
			}
			
			
			sumSal[pos] = sumSal[pos] + sal[i];
			
			
			
			salAvg[pos] = sumSal[pos] /count[pos];
			
			}
	}

	private static void output() {
		String head ="==========부서별 최저월급 , 최고월급==========";
		String title = "부서번호, 부서명, 월급합, 최저월급, 최고월급, 최저월급자, 최고월급자 ,인원수 , 월급평균";
		String fmt = "%s %s %.3f %.3f %.3f %s %s %d %.3f\n";
		String msg = "";
		System.out.println(head);
		System.out.println(title);
		for (int i = 0; i < N; i++) {
			msg = String.format(fmt,
					outDeptId[i],deptName[i],sumSal[i],minSal[i],
					maxSal[i],minSalName[i],maxSalName[i],count[i],salAvg[i]);
			System.out.println(msg);
		}
		
	}
}
