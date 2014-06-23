/**
* A Simple Java Program to check for the largest number
* @author mkc
*/
import javax.swing.JOptionPane;
import java.util.Scanner;

class LargestDemo{

  public static void main(String[] arguments){

    /** Part 1 Console Input */
    Scanner keyboard = new Scanner(System.in); 
    System.out.print("How many numbers would you like to enter? ");
    int n = keyboard.nextInt();

    /** Declare an Array */
    double[] num = new double[n]; 

    /** Input the elements */
    System.out.print("Input the numbers: ");
    for(int i = 0; i < n; i++)
        num[i] = keyboard.nextDouble();

    /** Display Result */
    System.out.println("The largest is " + largest(num) + ".");    
  }// ENDMAIN 

 /**
  * Returns the maximum from a list
  * Note: The syntax to declare a variable length formal parameter (list) is
	    dataType ... identifier
  * @params str input string
  */
 public static double largest(double ... numList)
 {
    double max;
    int index;
    if (numList.length != 0)
    {
        max = numList[0];
        for (index = 1; index < numList.length;
                        index++)
        {
            if (max < numList [index])
                max = numList [index];
        }
        return max;
    }
    return 0.0;
 }

}//ENDCLASS
