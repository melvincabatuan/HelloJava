import java.util.Scanner;

public class DISMATHInsertionSort{


	public void insertion(final int[] input) {
                int temp, i, j;              
                for(i = 1; i < input.length; i++){
                   System.out.print("i = " + i + "; ");
                   temp = input[i];
                   System.out.println("temp = " + temp);
                   j = i - 1; // index of previous element 
                   while(j > -1 && input[j] > temp){
                        input[j+1]=input[j];
                        j--; 
                   display(input);
                   }
                   input[j+1] = temp;   
                   display(input);                
                }
	}


        public static void display(final int[] array){           
           System.out.printf("{%d", array[0]);
		for (int i = 1; i < array.length; i++) {
			System.out.printf(", %d", array[i]);
		}
		 System.out.println("}");
        }


	public static void main(String[] args) {

                /// Input array
		final int array[] = new int[5];

                /// Input numbers to be sorted
		System.out.println("Enter 5 numbers");
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < array.length; i++) {
			array[i] = input.nextInt();
		}

		DISMATHInsertionSort mySort = new DISMATHInsertionSort();
                System.out.println("Insertion sorting ...");
                mySort.insertion(array);
                System.out.println("Sorted Array:");
                display(array);
 
	}
}
