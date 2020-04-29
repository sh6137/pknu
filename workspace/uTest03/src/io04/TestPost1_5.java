package io04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestPost1_5 {

	public static void main(String[] args) {
		/*
		 * 각 시도별 데이터를 별도의 파일로 출력 - 새종 포함 총 17개 시도 
		   zipcode.csv 
		   -> 서울.csv
		      부산.csv
		      대구.csv
      ...
		 * 
		 */
		
		String          path    =    "c:\\자바예제실험\\zipcode.csv";
		File            file    = new File(path);
		
		FileReader      fr      = null;
		BufferedReader  br      = null;
		
		FileWriter      fw       = null; 
		BufferedWriter  bw       = null; 
		
		try {
			fr     = new FileReader(file);
			br     = new BufferedReader(fr);
			
			String prevSido  = "";
			String line      = "";
			br.readLine();
			int cnt = 0;
						
			while( (line = br.readLine()) != null) {
				
				String sido = line.trim().split(",")[1];
				if( !sido.equals( prevSido ) ) {  // 시도가 바뀌었다
					// 서울.csv 만든다					
					String  oPath = "c:\\자바예제실험\\" + sido +  ".csv";
					fw            = new FileWriter(oPath);
					fw.close();
					// line 을 저장한다					
					prevSido = sido;					
				} 
				
				String  oPath = "c:\\자바예제실험\\" + prevSido +  ".csv";
				fw            = new FileWriter(oPath, true);
				bw            = new BufferedWriter(fw);
				
				bw.write( line + "\n");
				bw.flush();
				System.out.println(cnt + "." + line);
				cnt++;
				
				bw.close();
				fw.close();				
			}
			System.out.println("새로 완료");
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		} finally {
			try {
				if ( br != null) br.close();
				if ( fr != null) fr.close();
			} catch (IOException e) {				
			}
		}
		
		// 결과확인은 Excel 로 하면 한글이 깨짐 : MS949
		// 결과확인 NOTEPAD++ 로 확인하면 한글 제대로 보임

	}

}