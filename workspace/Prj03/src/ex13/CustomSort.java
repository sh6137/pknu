package ex13;

public class CustomSort {
	
	public static void display(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

	public static void bubble_sort(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-1-i; j++) {
				if(nums[j] > nums[j+1]) {
					int temp;
					temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		
	}

	public static void display(String[] names) {
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + " ");
		}
		System.out.println();
	}

	public static void bubble_sort(String[] names) {
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < names.length -1 -i; j++) {
				if(names[j].compareTo(names[j + 1]) >0) {
					String temp;
					temp = names[j];
					names[j] = names[j+1];
					names[j+1] = temp;
				}
			}
			
			
		}
		
	}

	public static void display(Student[] studs) {
		for (int i = 0; i < studs.length; i++) {
			System.out.print(studs[i].getName() + " ");
		}
		System.out.println();
	}



	public static void bubble_sort(Student[] studs,int i) {
		
//		switch(type) {
//		case SNAME:
//		default:
//			break;
//		
//		}
		if(i==1) {
			for (int j = 0; j < studs.length; j++) {
				for (int k = 0; k < studs.length  -1 -j; k++) {
					if(studs[k].getName().compareTo(studs[k+1].getName()) >0) {
						Student	[]tmep = new Student[1];
						tmep[0] = studs[k];
						studs[k] = studs[k+1];
						studs[k+1] = tmep[0];
					}
				}
			}
		}
		else if(i==2) {
			for (int j = 0; j < studs.length; j++) {
				for (int k = 0; k < studs.length  -1 -j; k++) {
					if(studs[k].getTel().compareTo(studs[k+1].getTel()) >0) {
						Student	[]tmep = new Student[1];
						tmep[0] = studs[k];
						studs[k] = studs[k+1];
						studs[k+1] = tmep[0];
					}
				}
			}
		}
		else if(i==3) {
			for (int j = 0; j < studs.length; j++) {
				for (int k = 0; k < studs.length  -1 -j; k++) {
					if(studs[k].getYear() > studs[k+1].getYear() ) {
						Student	[]tmep = new Student[1];
						tmep[0] = studs[k];
						studs[k] = studs[k+1];
						studs[k+1] = tmep[0];
					}
				}
			}
		}
		
	}

	
}
