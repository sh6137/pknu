package homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Homework {
	public static void main(String[] args) throws IOException {
		File file = new File("c:\\자바예제실험\\out4.txt");
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		Scanner in = new Scanner(System.in);
		System.out.println("입력(사번,이름,월급,보너스,입사연도,부서번호)종료 : exit");
		bw.write("사번,이름,총수령액,입사연도,부서명\n");
		
		int cateEmcount[] = new int[4];
		double cateSalay[] = new double[4];
		int totalcount=0;
		double totalSalay = 0;
		//무한반복영역
		while(true) {
			String inputLine = in.nextLine();
			
			if(inputLine.equalsIgnoreCase("exit"))break;
			
			String [] str = inputLine.split(",");
			int num = Integer.valueOf(str[0].trim());
			String name = str[1].trim();
			int salay = Integer.valueOf(str[2].trim());
			int bouns = Integer.valueOf(str[3].trim());//보너스
			int inYear = Integer.valueOf(str[4].trim());//입사연도
			int cateNum = Integer.valueOf(str[5].trim());//부서번호
			
			Employee em1 = new Employee(num, name, salay, bouns, inYear, cateNum);
			
//			System.out.println(em1.getTotalSalay());
//			System.out.println(em1.cateNum);
//			System.out.println(em1.cateNumName);
			
			String msg = em1.toString();
			bw.write(msg + "\n");
			
			
			if(cateNum == 10) {
				cateEmcount[0]++;
				cateSalay[0] += em1.getTotalSalay();
			}
			else if(cateNum == 20) {
				cateEmcount[1]++;
				cateSalay[1] += em1.getTotalSalay();
			}
			else if(cateNum == 30) {
				cateEmcount[2]++;
				cateSalay[2] += em1.getTotalSalay();
			}
			else if(cateNum == 40) {
				cateEmcount[3]++;
				cateSalay[3] += em1.getTotalSalay();
			}
			
			totalcount = cateEmcount[0]+cateEmcount[1]+cateEmcount[2]+cateEmcount[3];
			totalSalay = cateSalay[0] + cateSalay[1] + cateSalay[2] +cateSalay[3];
		}
		bw.write("인사부 자재부 연구부 총무부 총인원수\n");
		
		String fmt = "%d명 %d명 %d명 %d명 %d명 \n";
		String msg = String.format(fmt, cateEmcount[0], cateEmcount[1] ,cateEmcount[2], cateEmcount[3], totalcount );
		bw.write(msg);
		
		fmt = "%f월 %f원 %f원 %fd원 %f원 \n";
		msg = String.format(fmt, cateSalay[0], cateSalay[1] ,cateSalay[2], cateSalay[3], totalSalay );
		bw.write(msg);
		
		bw.write("인사부월급 자재부월급 연구부월급 총무부월급 총월급\n");
		bw.close();
		fw.close();
		System.out.println("저장");
		
		
	}
	
	
}
