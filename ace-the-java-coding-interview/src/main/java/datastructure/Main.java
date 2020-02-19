package datastructure;

public class Main {
	public static void main(String[] args) {
		number_1_remove_even_integers_from_array();
	}
	
	public static void number_1_remove_even_integers_from_array() {
		int[] arr = {1, 2, 4, 5, 10, 6, 3};
		int n=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2!=0)
				n++;
		}
		int[] oddArr = new int[n];
		int index = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2!=0) {
				oddArr[index]=arr[i];
				index++;
			}
		}
		for(int a:oddArr) {
			System.out.println(a);
		}
	}
}
