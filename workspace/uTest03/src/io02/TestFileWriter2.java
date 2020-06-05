package io02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter2 {
	
	public static void main(String[] args) {
		String path 	= "c:\\자바예제실험\\";
		String filename ="out4.shh";
		String filepath = path +"\\"+ filename;
		File   file 	= new File(filepath);
		FileWriter fw 	= null;
		try {
			
			fw = new FileWriter(file);
			fw.write("hello");
			
			
			fw.close();
			System.out.println("저장");
		} catch (IOException e) {
			System.out.println("파일 저장 중 오류 발생.\n 관리자에게 연락하세요" + e.getMessage());
			
		}finally {
			try {
				if(fw != null)
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
