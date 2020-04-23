package io01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestFileWriter2 {
	public static void main(String[] args) throws IOException {
		String filename ="c:\\자바예제실험\\out2.txt";
		File oFile = new File(filename);
		
		//---------존재여부확인
		if(oFile.canExecute())//존재하는지여부
			System.out.println("파일이 존재합니다.");
		else
			System.out.println("파일이 없습니다.");
		//-------------		
		
		FileWriter fw = new FileWriter(oFile);
		BufferedWriter bw1 = new BufferedWriter(fw);
		
		int num;
		String name;
		int kor;
		int eng;
		int mat;
		
		int total;
		double avg;
		Scanner in = new Scanner(System.in);
		
		System.out.println("번호,이름,국어,영어,수학 입력 : ");
		String inputString = in.nextLine();
		
		String [] str = inputString.split(",");
		num = Integer.valueOf(str[0].trim());
		name = str[1];
		kor = Integer.valueOf(str[2].trim());
		eng = Integer.valueOf(str[3].trim());
		mat = Integer.valueOf(str[4].trim());
		
		total = kor+eng+mat;
		avg = (double)total/3;
		
		bw1.write("번호 이름 국어 영어 수학 총점 평균\n");
		
		System.out.println(inputString + "총점 : " + total  + "평균 : " + avg);
		String msg = "";
		String format = "%d %s %d %d %d 총점 : %d 평균 : %.4f";
		msg = String.format(format, num, name, kor, eng, mat, total, avg);
		
		bw1.write(msg);
		bw1.close();
		fw.close();
	}
}
