package io02;

import java.io.FileInputStream;
import java.io.IOException;

public class TestInputStream {
	public static void main(String[] args) throws IOException {
		String infile = ("c:\\자바예제실험\\abc2.txt");
		FileInputStream fis = new FileInputStream(infile);
		
		int ch;
		while((ch = fis.read()) != -1) { //EOF (end of file, -1) 이 나올때 까지 반복 한문자씩 읽는다.
			System.out.print((char)ch);
		}
		fis.close();
	}
}
