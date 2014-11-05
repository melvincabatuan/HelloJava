import java.util.Scanner;

public class DISMATHLinearSearch {
	public int find(final int[] data, final int key) {
                int location = -1; 
		for (int i = 0; i < data.length; ++i) {
                     if (data[i] == key){
		         location = i;
                     }
		}
		return location;

	}

	public static void main(String[] args) {
		final int arr[] = new int[10];
		System.out.println("Enter 10 numbers");

		Scanner input = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
		DISMATHLinearSearch search = new DISMATHLinearSearch();

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
