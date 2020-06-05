package homework;

public class Employee {
	int num; //사번
	String name;//이름
	int salay;//월금
	int bouns;//보너스
	int inYear;//입사연도
	int cateNum;//부서번호
	String cateNumName;//부서명
	int emCount; // 인원수
//	int cateEmCount10; //부서별인원수 인사
//	int cateEmCount20; //부서별인원수 자재
//	int cateEmCount30; //부서별인원수 연구
//	int cateEmCount40; //부서별인원수 총무
//	
//	int cateSalay10;//부서별월급총액 인사
//	int cateSalay20;//부서별월급총액 자재
//	int cateSalay30;//부서별월급총액 연구
//	int cateSalay40;//부서별월급총액 총무

	
	
	public Employee(int num, String name, int salay, int bouns, int inYear, int cateNum) {
		this.num = num;
		this.name = name;
		this.salay = salay;
		this.bouns = bouns;
		this.inYear = inYear;
		this.cateNum = cateNum;
		
		getTotalSalay();
		
		getCateNumName();
		
	}
	public double getTotalSalay() {
		
		return this.salay + this.bouns + (this.salay* getYear() * 0.5);
		
	}
	
	public int getYear() {
		return 2020 - inYear;
	}

	public String getCateNumName() {
		if(this.cateNum == 10) {
			this.cateNumName = "인사";
		}
		else if(this.cateNum == 20) {
			this.cateNumName = "자재";
		}
		else if(this.cateNum == 30) {
			this.cateNumName = "연구";
		}
		else if(this.cateNum == 40) {
			this.cateNumName = "총무";
		}
		return cateNumName;
	}

	
	@Override
	public String toString() {
		String fmt = "사번 %d,이름 %s,총수령액 %f,입사연도 %d,부서명 %s";
		String msg = String.format(fmt, 
				this.num, this.name, getTotalSalay(),
				this.inYear, this.cateNumName);
		return msg;
		}
}
