import java.util.Scanner;

public class DISMATHBubbleSort{


	public void bubble(final int[] input) {
                int temp;              
                for(int i = 0; i < input.length - 1; i++){
                    System.out.println("i = " + i);
                    for(int j = 0; j < input.length - i - 1; j++){
                        if(input[j] > input[j+1]){ /// Swap the two values
                           temp = input[j];
                           input[j] = input[j+1]; 
                           input[j+1] = temp;
                         }
                      display(input);
                    } 
                  //display(input);
                }
	}

         
        public void bubble2(final int[] input) {
                int temp; // temporary variable used in swapping
                int swaps; // number of swaps per iteration  
                int i = 0; // bubble sort iteration        
                while(true){
                    System.out.println("i = " + i);
                    swaps = 0;

                    for(int j = 0; j < input.length - i - 1; j++){
                        if(input[j] > input[j+1]){ /// Swap the two values
                           temp = input[j];
                           input[j] = input[j+1]; 
                           input[j+1] = temp;
                           swaps++;
                         }
                      display(input);
                    }

                    /// termination/ sentinel
                   if (swaps == 0)
                     break;

                   i++;
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

		DISMATHBubbleSort mySort = new DISMATHBubbleSort();
                System.out.println("Bubble sorting ...");
                mySort.bubble(array);
                System.out.println("Sorted Array:");
                display(array);
                //System.out.println("Bubble sorting (modified)...");
                //mySort.bubble2(array);
                //System.out.println("Sorted Array:");
                //display(array);     
	}
}
