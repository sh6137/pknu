package ex05;

import java.util.Arrays;

public class Text09 {
	public static void main(String[] args) {
		char[] arr1 = {'j','a','v','a'};
		System.out.printf(
				"%c %c %c %c"
				,arr1[0],arr1[1],arr1[2],arr1[3]);
		
		char[] arr1_2 = new char[arr1.length];
		arr1_2[0] = arr1[0];
		arr1_2[1] = arr1[1];
		arr1_2[2] = arr1[2];
		arr1_2[3] = arr1[3];
		
		
		char[] arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(Arrays.toString(arr2));
		
		char[] arr3 = Arrays.copyOfRange(arr1, 1, 3);
		System.out.println(Arrays.toString(arr3));
		
		char[] arr4 = new char[arr1.length];
		System.arraycopy(arr1, 0, arr4, 0, arr1.length);
		System.out.println(Arrays.toString(arr4));
	}
}
