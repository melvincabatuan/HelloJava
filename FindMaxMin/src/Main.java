public class Main {

	public static void main(String[] args) {

		// array of 10 numbers
		int numbers[] = new int[] { 11, 43, 53, 54, 99, 65, 63, 98, 43, 23, 101 };
		int max = findMax(numbers);
		int min = findMin(numbers);

		System.out.println("Largest Number is : " + max);
		System.out.println("Smallest Number is : " + min);
	}

	public static int findMax(int num[]) {
		int largest = num[0];

		for (int i = 1; i < num.length; i++) {
			if (num[i] > largest)
				largest = num[i];
		}
		return largest;
	}

	public static int findMin(int num[]) {
		int smallest = num[0];

		for (int i = 1; i < num.length; i++) {
			if (num[i] < smallest)
				smallest = num[i];
		}
		return smallest;
	}

}// ENDCLASS
