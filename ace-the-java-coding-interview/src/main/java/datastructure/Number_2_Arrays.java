package datastructure;

public class Number_2_Arrays {
	public static void main(String[] args) {
		number_10_rearrange_sorted_array_in_min_max_form();
		//number_9_rearrange_positive_and_negative_values();
		// number_8_right_rotate_the_array_by_one_index();
		// number_7_find_second_maximum_value_in_an_array();
		// number_6_first_non_repeating_integer_in_an_array();
		// number_5_find_minimum_value_in_an_array();
		// number_4_array_of_products_of_all_elements_except_itself();
		// number_3_find_two_numbers_that_add_upto_n();
		// number_2_merge_two_sorted_arrays();
		// number_1_remove_even_integers_from_array();
	}

	public static void number_10_rearrange_sorted_array_in_min_max_form() {
		int[] arr = {1, 2, 3, 4, 5};
		int[] resultArr = new int[arr.length];
		
		int pointerSmall = 0;
		int pointerLarge = arr.length-1;
		
		boolean switchPointer = true;
		
		for(int i=0; i<arr.length; i++) {
			if(switchPointer) {
				resultArr[i] = arr[pointerLarge--];
			}
			else {
				resultArr[i] = arr[pointerSmall++];
			}
			switchPointer = !switchPointer;
		}
		for(int a : resultArr) {
			System.out.println(a);
		}
	}
	
	public static void number_9_rearrange_positive_and_negative_values() {
		int[] arr = { 10, -1, 20, 4, 5, -9, -6 };
		int[] arr2 = new int[arr.length];

		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				arr2[counter] = arr[i];
				counter++;
			}
		}

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] >= 0) {
				arr2[counter] = arr[i];
				counter++;
			}
		}

		for (int a : arr2) {
			System.out.println(a);
		}
	}

	public static void number_8_right_rotate_the_array_by_one_index() {
		int[] arr = { 1, 2, 3, 4, 5 };
		int s = arr.length;
		int[] rotatedArray = new int[s];
		rotatedArray[0] = arr[s - 1];
		for (int i = s - 1; i > 0; i--) {
			rotatedArray[i] = arr[i - 1];
		}
		for (int a : rotatedArray) {
			System.out.println(a);
		}
	}

	public static void number_7_find_second_maximum_value_in_an_array() {
		int[] arr = { 9, 11, 2, 3, 6, 1, 100 };
		int max = arr[0];
		int secondMax = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				int temp = max;
				max = arr[i];
				secondMax = temp;
			}
		}
		System.out.println(max + "---" + secondMax);
	}

	public static void number_6_first_non_repeating_integer_in_an_array() {
		int[] arr = { 1, 1, 9, 2, 3, 2, 6, 6 };
		int nonrepeating = 0;
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			int contender = arr[i];
			for (int j = 0; j < arr.length; j++) {
				if (i != j) {
					if (arr[i] == arr[j]) {
						count++;
					}
				}
			}
			if (count == 0) {
				nonrepeating = contender;
				break;
			}
		}
		System.out.println(nonrepeating);
	}

	public static void number_5_find_minimum_value_in_an_array() {
		int[] arr = { 9, 2, 3, 6 };
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println(min);
	}

	public static void number_4_array_of_products_of_all_elements_except_itself() {
		int[] arr = { 1, 2, 3, 4 };
		int[] productArray = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int n = 1;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] != arr[j])
					n = n * arr[j];
			}
			productArray[i] = n;
		}
		for (int i : productArray) {
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
