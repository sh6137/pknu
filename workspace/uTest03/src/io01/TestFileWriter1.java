package io01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter1 {
	//새로운 파일 생성
	//open(),close() 하면 새로운 파일이 만들어 진다.
	public static void main(String[] args) throws IOException {
		File outFile = new File("c:\\자바예제실험\\out1.txt");
		if(outFile.canExecute())//존재하는지여부
			System.out.println("파일이 존재합니다.");
		else
			System.out.println("파일이 없습니다.");
		
		FileWriter fw1 = new FileWriter(outFile);
		BufferedWriter bw1 = new BufferedWriter(fw1);
	
		String msg = "안녕하세\n홍길동\n";
		String []names = {"가","나","다","라","마",};
		
		for (int i = 0; i < names.length; i++) {
			msg = String.format("%d %s\n", (i+1), names[i]);
			bw1.write(msg);
		}
		
		
		bw1.close();
		fw1.close();
		
		System.out.println(outFile.getName() + "파일이 저장되었습니다.");
		
		
	}		
}
