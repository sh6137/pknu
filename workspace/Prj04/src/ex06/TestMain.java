package ex06;

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
	10, A, 20010101, 300.0, 10
	10, B, 20050101, 240.0, 10
	10, C, 20070101, 220.0, 20
	10, D, 20090101, 260.0, 30
	10, E, 20120101, 350.0, 40
	10, F, 20170101, 195.0, 50
	*/
	static final int ROW=6;
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
	
	public static void main(String[] args) {
		input();
		process();
		output();
		
	}

	private static void input() {
		// TODO Auto-generated method stub
		
	}
	
	private static void init_data() {
		//입력
		
		empId = new String[ROW];
		empName = new String[ROW];
		hiredate  = new String[ROW];
		sal = new double[ROW];
		deptId = new String[ROW];
	
		//출력
		bonus = new double[ROW];
		pay = new double[ROW];
		deptName = new String[ROW];
	}

	private static void process() {
		// TODO Auto-generated method stub
		
	}


	private static void output() {
		// TODO Auto-generated method stub
		
	}
}
