/**
* Prints n Fibonacci Numbers
* @author mkc
*/
import java.util.Scanner;
import java.util.ArrayList;

class Fibonacci{

  public static void main(String[] arguments){
    Scanner keyboard = new Scanner(System.in);
    int n; // User input

    while(true){
         System.out.print("Enter how many Fibonacci numbers would you like to display or -1 to quit: ");
         n = keyboard.nextInt(); 
         
         /** Quit if n is -1 */  
         if (n == -1) break;
 
         else if (n >= 1){
             int[] fib = new int[n];
             fib[0] = 1;
             fib[1] = 1;
             for(int i = 2; i < n; i++)
                 fib[i] = fib[i-1] + fib[i-2]; 
               System.out.println("The Fibonacci Numbers are: ");
             for(int i = 0; i < n; i++) 
               System.out.print(" " + fib[i]);
             System.out.println();
         }
         else
           System.out.println("Invalid Input!");                  

    } // ENDWHILE 
  } //ENDMAIN
}
