package io02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestoutputStream {
	public static void main(String[] args) throws IOException {
		String 	filename = ("c:\\자바예제실험\\abc3.txt");
		File	file	 = new File(filename);
		FileOutputStream fos = new FileOutputStream(file);
		
		for (int i = 'A' ; i <= 'Z' ; i++) {
			fos.write(i);
		}
		fos.close();
	}
}
