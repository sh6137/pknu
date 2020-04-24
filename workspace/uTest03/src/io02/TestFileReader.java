package io02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestFileReader {
	public static void main(String[] args) throws IOException {
		String filename = ("c:\\자바예제실험\\name.txt");
		
		FileReader 		fr = new FileReader(filename);
		BufferedReader 	br = new BufferedReader(fr);
		
		String line = "";
		int num =1;
		while ((line = br.readLine()) != null) { //파일끝까지 반복해서 읽어라
			String name = line;
			System.out.println(num +"."+ name);
			num++;
		}
		
		
		br.close();
		fr.close();
		System.out.println("하이");
	}
}
