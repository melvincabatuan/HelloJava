import java.util.Scanner;

public class LinearSearch {
	public int find(final int[] data, final int key) {
		for (int i = 0; i < data.length; ++i) {
			if (data[i] > key)
				return -1;
			else if (data[i] == key)
				return i;
		}
		return -1;

	}

	public static void main(String[] args) {
		final int arr[] = new int[10];
		System.out.println("Enter 10 numbers");
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
		LinearSearch search = new LinearSearch();
		System.out.print("Enter the element to search: ");
		int num = input.nextInt();
		int n = search.find(arr, num);
		if ((n >= 0) && (n < arr.length)) {
			System.out.println("Found at index: " + n);
		} else {
			System.out.println("Not Found");
		}
	}
}