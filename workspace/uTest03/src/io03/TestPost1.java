package io03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestPost1 {
	static int cnt = 0;
	public static void main(String[] args) {
		String path = "c:\\자바예제실험\\zipcode.csv";
		File file = new File(path);
		File file2 = new File("c:\\자바예제실험\\서울.csv");
		
		
		
		if(!file.exists()) {
			System.out.println(path + "파일이 없습니다.");
			//return; //함수 종료
			System.exit(0); //시스템 강제 종료
		}
		
		FileReader fr =  null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String line = "";
			while((line = br.readLine()) != null) {
				
				address_work(line);
				sidoName();
				
			}
			System.out.println(cnt);
			System.out.println("저장완료");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없음");
		} catch (IOException e) {
			System.out.println("입출력오류" + e.getMessage());
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

	private static void sidoName() {
		
	}

	private static void address_work(String line) {
		
		String [] addr = line.trim().split(",");
		//zipcode,sido,gugun,dong,bunji,seq
		String zipcode 	= addr[0].trim();
		String sido		= addr[1].trim();
		String gugun	= addr[2].trim();
		String dong 	= addr[3].trim();
		String bunji    = addr[4].trim();
		String seq      = addr[5].trim();
		
		
		String fmt = "%s %s %s %s %s %s";
		String msg = "";
		
		if(dong.contains("롯데백화점")) {
			msg 		= String.format(fmt, zipcode,sido,gugun,dong,bunji,seq); 
			System.out.println(msg);
			cnt++;
		}
		
	}
}
