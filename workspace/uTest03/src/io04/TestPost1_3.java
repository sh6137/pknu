package io04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TestPost1_3 {
	public static void main(String[] args) {
		//zipcode,sido,gugun,dong,bunji,seq
		
		//1.전국 시도(sido)명 출력 - 중복제거
		//  전국 시도 갯수 출력
		
		String path = "c:\\자바예제실험\\zipcode.csv";
		File file = new File(path);
		File file2 = new File("c:\\자바예제실험\\서울.csv");
		
		FileReader fr= null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String line = "";
			//title 줄을 읽어서 버림
			br.readLine(); //제목줄 skip
			//br.skip(바이트수); //byte 수 만큼 레코드 포인트를 skip
			Set<String> sidoSet = new HashSet<String>();
			String preSido = "";
			int sidoCount = 0;
			while( (line = br.readLine()) !=null) {
				String [] addr = line.trim().split(",");
				String sido = addr[1].trim();
				
				if(!preSido.equals(sido)) {
					
						sidoSet.add(sido);
						preSido = sido;
						sidoCount++;
					
					
				}
			}
			for (String sido : sidoSet) {
				System.out.println(sido);
			}
			System.out.println("전체 시도수 : " + sidoSet.size());
			
			System.out.println("작업종료");
		} catch (IOException e) {
			System.out.println("오류발생" + e.getMessage());
		} finally {
			try {
				if(br!=null) br.close();
				if(fr!=null) fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
