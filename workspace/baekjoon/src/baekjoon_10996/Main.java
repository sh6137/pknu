package baekjoon_10996;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int height = sc.nextInt();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					for (int k = 0; k < height; k++) {
						if (k % 2 == 0) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					}
					System.out.println();
				}
				if (j == 1) {
					for (int k = 0; k < height; k++) {
						if (k % 2 == 0) {
							System.out.print(" ");
						} else {
							System.out.print("*");
						}
					}
					System.out.println();
				}
			}
		}
	}
}