import java.util.Scanner;

public class DISMATHBinarySearch {


	public int find(final int[] data, final int key) {
                int location = -1; 
                int begin = 0; // beginning of the index
                int end = data.length - 1; // end of the index
                int mid = 0;

		while (begin < end) {

                     // Display the begin and end indices
                     System.out.println("begin = " + begin + " ; end = " + end); 

                     // Get the index of the last element of lower half
                     mid = (int) Math.floor((begin + end)/2.0);

                     // Display the last element of lower half
                     System.out.println("data[" + mid +"] = " + data[mid]);

                     // Choose the upper or lower half of data 
                     if (data[mid] < key)
                         begin = mid + 1;  // upper half of data 
                     else
                         end = mid;        // lower half of data 
		}

                // Update location if element is found; default location = -1 (not found)
                if (data[begin] == key) location = begin;

		return location;
	}

	public static void main(String[] args) {
		final int arr[] = new int[16];
		System.out.println("Enter 16 numbers");

		Scanner input = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}

		DISMATHBinarySearch search = new DISMATHBinarySearch();

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
