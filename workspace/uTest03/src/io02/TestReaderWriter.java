package io02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestReaderWriter {
	
	public static void main(String[] args) {
		
		File file1 = new File("c:\\자바예제실험\\name.txt");
		File file2 = new File("c:\\자바예제실험\\name_result.txt");
		
		FileReader 		fr = null;
		BufferedReader 	br = null;
		
		FileWriter 		fw = null;
		BufferedWriter 	bw = null;

		try { 
			 fr = new FileReader(file1);
			 br = new BufferedReader(fr);
			 fw = new FileWriter(file2);
			 bw = new BufferedWriter(fw);
			 
			 String line = "";
			 int num = 1;
			 while((line = br.readLine()) != null) {
				String name = line;
				
				String fmt = "%03d. %s\r\n";
				String msg = String.format(fmt, num,name);
				
				System.out.println(msg);
				bw.write(msg);
				num++;
				 
			 }
			 
			 System.out.println("작업완료");
		} catch (FileNotFoundException e) {
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
