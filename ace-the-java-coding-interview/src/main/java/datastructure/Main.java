package datastructure;

public class Main {
	public static void main(String[] args) {
		//number_4_array_of_products_of_all_elements_except_itself();
		//number_3_find_two_numbers_that_add_upto_n();
		// number_2_merge_two_sorted_arrays();
		// number_1_remove_even_integers_from_array();
	}

	public static void number_5_find_minimum_value_in_an_array() {
		
	}
	
	public static void number_4_array_of_products_of_all_elements_except_itself() {
		int[] arr = {1,2,3,4};
		int[] productArray = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			int n = 1;
			for(int j=0; j<arr.length; j++) {
				if(arr[i]!=arr[j])
					n = n*arr[j];
			}
			productArray[i] = n;
		}
		for(int i : productArray) {
			System.out.println(i);
		}
	}
	
	public static void number_3_find_two_numbers_that_add_upto_n() {
		int[] arr = { 1, 21, 3, 14, 5, 60, 7, 6 };
		int value = 27;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == value) {
					System.out.println(arr[i] + " " + arr[j]);
				}
			}
		}
	}

	public static void number_2_merge_two_sorted_arrays() {
		int[] arr1 = { 1, 3, 4, 5, 11, 19 };
		int[] arr2 = { 2, 6, 7, 8, 9 };
		int[] arr3 = new int[arr1.length + arr2.length];
		int i = 0;
		int j = 0;
		int index = 0;
		while (i < arr1.length && j < arr2.length) {
			System.out.println(arr1[i] + "---" + arr2[j]);
			if (arr1[i] < arr2[j])
				arr3[index++] = arr1[i++];
			else
				arr3[index++] = arr2[j++];
		}
		while (i < arr1.length) {
			arr3[index++] = arr1[i++];
		}
		while (j < arr2.length) {
			arr3[index++] = arr2[j++];
		}
		for (int a : arr3) {
			System.out.print(a + " ");
		}
	}

	public static void number_1_remove_even_integers_from_array() {
		int[] arr = { 1, 2, 4, 5, 10, 6, 3 };
		int n = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0)
				n++;
		}
		int[] oddArr = new int[n];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				oddArr[index] = arr[i];
				index++;
			}
		}
		for (int a : oddArr) {
			System.out.println(a);
		}
	}
}
