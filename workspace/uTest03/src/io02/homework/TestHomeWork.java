package io02.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestHomeWork {
	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
		String search;
		File file1 = new File("c:\\자바예제실험\\zipcode.txt");
		File file2 = new File("c:\\자바예제실험\\zipcodeResult.txt");
		
		FileReader fr = null;
		BufferedReader br = null;
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		System.out.println("입력 : ");
		search = in.nextLine();
		System.out.println(search);
		System.out.println("----------");
		try {
			fr = new FileReader(file1);
			br = new BufferedReader(fr);
			
			fw = new FileWriter(file2);
			bw = new BufferedWriter(fw);
			String line = "";
			int num = 1;
			while((line = br.readLine()) !=null) {
				String name = line;
				
				
				if(name.contains(search)==true) {
					System.out.println(name);
					String msg = name;
					bw.write(msg + "\n");
				}
				
				
			}
			
			
		}  catch (FileNotFoundException e) {
			System.out.println("파일없습니다." + e.getMessage());
		}catch (IOException e) {
			System.out.println("오류발생" + e.getMessage());
		}
		finally {
			try {
				if(br != null) br.close();
				if(fr != null) fr.close();
				if(bw != null) bw.close();
				if(fw != null) fw.close();
			} catch (IOException e) {}
		}
		
	}
}
