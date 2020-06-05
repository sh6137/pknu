package io02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestReaderWriter2 {
	
	public static void main(String[] args) {
		
		File file1 = new File("c:\\자바예제실험\\name.txt");
		File file2 = new File("c:\\자바예제실험\\name_result2.txt");
		
		FileReader 		fr = null;
		BufferedReader 	br = null;
		
		FileWriter 		fw = null;
		BufferedWriter 	bw = null;

		try { 
			 fr = new FileReader(file1);
			 br = new BufferedReader(fr);
			 fw = new FileWriter(file2);
			 bw = new BufferedWriter(fw);
			 String []spaceName = new String[4];
			 int []state = new int[7];
//0.남구 1.북구 2.중구 3.동구 4.서구 5.해운대구 6.사하구
			 String line = "";
			 int num = 1;
			 
			 //팀정하기
			 String fName = "";
			 String team = "";
			 while((line = br.readLine()) != null) {
				String name = line;
				
				
				spaceName[0] = name.substring(0,1);
				spaceName[1] = name.substring(1,2);
				spaceName[2] = name.substring(2,3);
				spaceName[3] = name.substring(5);
				
				fName = spaceName[0];
				System.out.println("성 " + fName);
				fName = sort(fName);
				
				switch (fName) {
				case "ㄱ":team = "1팀";break;
				case "ㄴ":team = "2팀";break;
				case "ㄷ":team = "3팀";break;
				case "ㄹ":team = "4팀";break;
				case "ㅁ":team = "5팀";break;
				case "ㅂ":team = "6팀";break;
				case "ㅅ":team = "7팀";break;
				case "ㅇ":team = "8팀";break;
				case "ㅈ":team = "9팀";break;
				case "ㅊ":team = "10팀";break;
				case "ㅋ":team = "11팀";break;
				case "ㅌ":team = "12팀";break;
				case "ㅍ":team = "13팀";break;
				case "ㅎ":team = "14팀";break;
				
				}
				

				System.out.println("팀 "+team);
				String fmt = "%03d.%s %s %s , %s , %s\r\n";
				String msg = String.format(fmt, num, spaceName[0], spaceName[1], spaceName[2],spaceName[3],team );
				
				System.out.println(msg);
				bw.write(msg);
				
				
				num++;	 
				
				
				if(spaceName[3].equals("남구")) {
					state[0]++;
				}
				else if(spaceName[3].equals("북구")) {
					state[1]++;
				}
				else if(spaceName[3].equals("중구")) {
					state[2]++;
				}
				else if(spaceName[3].equals("동구")) {
					state[3]++;
				}
				else if(spaceName[3].equals("서구")) {
					state[4]++;
				}
				else if(spaceName[3].equals("해운대구")) {
					state[5]++;
				}
				else if(spaceName[3].equals("사하구")) {
					state[6]++;
				}
			 }
			 bw.write("---------------\n");
			 String msg = String.format("남구 : %d명\n"
			 		+ "북구 : %d명\n"
			 		+ "중구 : %d명\n"
			 		+ "동구 : %d명\n"
			 		+ "서구 : %d명\n"
			 		+ "해운대구 : %d명\n"
			 		+ "사하구 : %d명\n"
			 		,state[0],state[1],state[2]
			 		,state[3],state[4],state[5],state[6]
					 );
			 bw.write(msg);
			 
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

	public static String sort(String fName) {
		if (fName.compareTo("가") >= 0 && fName.compareTo("낗") <= 0) return "ㄱ";
		if (fName.compareTo("나") >= 0 && fName.compareTo("닣") <= 0) return "ㄴ";
		if (fName.compareTo("다") >= 0 && fName.compareTo("띻") <= 0) return "ㄷ";
		if (fName.compareTo("라") >= 0 && fName.compareTo("맇") <= 0) return "ㄹ";
		if (fName.compareTo("마") >= 0 && fName.compareTo("밓") <= 0) return "ㅁ";
		if (fName.compareTo("바") >= 0 && fName.compareTo("삫") <= 0) return "ㅂ";
		if (fName.compareTo("사") >= 0 && fName.compareTo("앃") <= 0) return "ㅅ";
		if (fName.compareTo("아") >= 0 && fName.compareTo("잏") <= 0) return "ㅇ";
		if (fName.compareTo("자") >= 0 && fName.compareTo("짛") <= 0) return "ㅈ";
		if (fName.compareTo("차") >= 0 && fName.compareTo("칳") <= 0) return "ㅊ";
		if (fName.compareTo("카") >= 0 && fName.compareTo("킿") <= 0) return "ㅋ";
		if (fName.compareTo("타") >= 0 && fName.compareTo("팋") <= 0) return "ㅌ";
		if (fName.compareTo("파") >= 0 && fName.compareTo("핗") <= 0) return "ㅍ";
		if (fName.compareTo("하") >= 0 && fName.compareTo("힣") <= 0) return "ㅎ";
		return fName;
		
		
		
	}
	
}
