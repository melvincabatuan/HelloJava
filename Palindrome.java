/**
* A Simple Java Program to check for a Palindrome string
* using both console and JOptionPane I/O
* @author mkc
*/
import javax.swing.JOptionPane;
import java.util.Scanner;

class Palindrome{

  public static void main(String[] arguments){

    /** Part 1 Console Input */
    Scanner keyboard = new Scanner(System.in); 
    System.out.print("Enter a string: ");
    String inputStr1 = keyboard.nextLine();

    /** Display Result */
    if(Palindrome.isPalindrome(inputStr1))
       System.out.print("The string " + inputStr1 + " is a Palindrome.");
    else
       System.out.print("The string " + inputStr1 + " is NOT a Palindrome.");

    /** Part 1 GUI Input using JOptionPane */
    String inputStr2 = JOptionPane.showInputDialog("Enter a string: ");

    /** Handles null input */
    if (inputStr2 == null)
        return;

    /** Display Result */
    if(Palindrome.isPalindrome(inputStr2))
       JOptionPane.showMessageDialog(null, "The string " + inputStr2 + " is a Palindrome.");
    else
       JOptionPane.showMessageDialog(null, "The string " + inputStr2 + " is NOT a Palindrome.");

  }// ENDMAIN 

 /**
  * using both console and JOptionPane I/O
  * @params str input string
  */
  public static boolean isPalindrome(String str)
  {
    int len = str.length();                   
    int i, j;
    j = len - 1; 

    for (i = 0; i <= (len - 1) / 2; i++)
    {
        if (str.charAt(i) !=  str.charAt(j))
            return false;
        j--;                                  
    }
    return true;                              
   }//ENDisPalindrome

}//ENDCLASS
