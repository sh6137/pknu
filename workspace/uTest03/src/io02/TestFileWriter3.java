package io02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter3 {
	public static void main(String[] args) throws IOException {
		File file = new File("c:\\자바예제실험\\out5.son");
		
		//신규생성
		FileWriter fw = new FileWriter(file);
		fw.close();
		
		//추가기능모드로 열기
		//true : append 의미 자료가 계속 쌓여서 보관된다.
		fw = new FileWriter(file,true);
		
		fw.write("ss헬로\n");
		fw.write("ss헬로\n");
		fw.close();
		
	}
}
