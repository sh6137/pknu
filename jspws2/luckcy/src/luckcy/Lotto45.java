package luckcy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lotto45 {
	public static void main(String[] args) {
		 
		Lotto45 lotto = new Lotto45();
		Scanner sc = new Scanner(System.in);
 
		System.out.print("로또번호 추출 개수 입력: ");
		int gameCnt = sc.nextInt();
 
		for (int i = 1; i <= gameCnt; i++) {
			System.out.println(
					i + "번째 로또번호: " + lotto.lottoNumbers());
		}
	}
 
	String lottoNumbers() {
 
		List<Integer> lottoNum = new ArrayList<Integer>();
		
		// List 안에 로또번호 추가 
		for (int i = 1; i <= 45; i++) {
			lottoNum.add(i);
		}
 
		// set안의 수를 무작위로 섞는다
		Collections.shuffle(lottoNum);
 
		int[] lottoNums = new int[6];
		for (int i = 0; i < 6; i++) {
			lottoNums[i] = lottoNum.get(i);
		}
		
		// 정렬
		Arrays.sort(lottoNums);
 
		return Arrays.toString(lottoNums);
	}
}
