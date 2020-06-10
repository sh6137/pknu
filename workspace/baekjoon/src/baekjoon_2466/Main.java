package baekjoon_2466;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height;
		height = sc.nextInt();

		for (int i = 0; i < 2 * height - 1; i++) {
			if (i < height) {
				for (int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				for (int k = 0; k < 2 * (height - i) - 1; k++) {
					System.out.print("*");
				}
				System.out.println();
			} else {
//				height는 5이면 i는 5
//				height가 6이면 i는 6
//				height가 7이면 i는 7
//				띄우기는 i-2, i-3, i-4...
				for (int j = i + 1; j >= 2 * (i - height + 2); j--) {
					System.out.print(" ");
				}

//            *찍기는  3, 5, 7, 9...
				for (int k = 0; k < 2 * (i - height + 2) - 1; k++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
}