package io02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Student{
	int num;
	String name;
	int kor;
	int eng;
	int mat;
	
	
	
	
	public Student(int num, String name, int kor, int eng, int mat) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
//		getTot();
//		getAvg();
	}
	
	public int getTot() {
		return this.kor + this.eng + this.mat;
	}
	
	public int getAvg() {
		return getTot() /3;
	}

	@Override
	public String toString() {
		String fmt = "%d %s %d %d %d 총정 : %d 평균 : %d";
		String msg = String.format(fmt, 
				this.num, this.name, this.kor,
				this.eng, this.mat,
				getTot(), getAvg());
		
		return msg;
	}
	
	
	
}

public class TestFileWriter {
	public static void main(String[] args) throws IOException {
		
		File file = new File("c:\\자바예제실험\\out3.txt");
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		//키보드 입력부
		Scanner in = new Scanner(System.in);
		System.out.println("입력(번호,이름,국어,영어,수학)종료 : exit");
		bw.write("번호 이름 국어 영어 수학 총점 평균 \n");
		
		//무한 반복영역
		while(true) {
		String inputLine = in.nextLine();
		
		if(inputLine.equalsIgnoreCase("exit"))break; //무한루프탈출
		
		String [] str = inputLine.split(",");
		int num = Integer.valueOf(str[0].trim());
		String name = str[1].trim();
		int kor = Integer.valueOf(str[2].trim());
		int eng = Integer.valueOf(str[3].trim());
		int mat = Integer.valueOf(str[4].trim());
		
		Student s1  = new Student(num, name, kor, eng, mat);
		//출력부
		bw.write("번호 이름 국어 영어 수학\n");
		
		String msg = s1.toString();
		bw.write(msg + "\n");
		}
		//반복영역끝
		bw.close();
		fw.close();
		System.out.println("저장");
	}
	
}
