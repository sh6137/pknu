package obj17;

public class CustomSort {
	// bubble sort
	public static void bubble_sort(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n - 1 ; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if(nums[j]  > nums[j+1]) {
					int temp  =  nums[j];
					nums[j]   =  nums[j+1];
					nums[j+1] =  temp; 
				}
			}
		}

	}

	public static void display_array(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}	
		System.out.println();
	}

	public static void display_array(String[] names) {
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + " ");
		}	
		System.out.println();		
	}

	public static void bubble_sort(String[] names) {
		int n = names.length;
		for (int i = 0; i < n - 1 ; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if(names[j].compareTo(names[j+1]) > 0) {
					String temp  =  names[j];
					names[j]     =  names[j+1];
					names[j+1]   =  temp; 
				}
			}
		}
		
	}

	public static void display_Object(Student[] students) {
		for (int i = 0; i < students.length; i++) {
			System.out.println( students[i].toString() );
		}		
	}

	public static void bubble_sort(Student[] arr, int key) {
		// key : 1:name, 2:tel, 3:inYear		
		int n = arr.length;
		for (int i = 0; i < n - 1 ; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				switch(key) {
				case 1:
					if(arr[j].getName().compareTo(arr[j+1].getName()) > 0) {
						Student temp  =  arr[j];
						arr[j]        =  arr[j+1];
						arr[j+1]      =  temp; 
					}
					break;
				case 2:
					if(arr[j].getTel().compareTo(arr[j+1].getTel()) > 0) {
						Student temp  =  arr[j];
						arr[j]     =  arr[j+1];
						arr[j+1]   =  temp; 
					}
					break;
				case 3:
					if(arr[j].getInYear() > arr[j+1].getInYear() ) {
						Student temp  =  arr[j];
						arr[j]        =  arr[j+1];
						arr[j+1]      =  temp; 
					}
					break;
				}		
			}
		}
		
	}
}
