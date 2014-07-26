import java.util.*;

public class ExceptionDemo{

  public static void main(String [] args){
   Scanner keyboard = new Scanner(System.in);
   int terminator = 0;

   do{
      try{
        System.out.println("Enter numerator integer: ");
        int num = keyboard.nextInt();

        System.out.println("Enter denominator integer: ");
        int den = keyboard.nextInt();

        int q = num/den; // ERROR Prone
        System.out.println("q = " + q);

        terminator = 1; // Terminates the loop
      }

      catch(Exception e){
        System.out.println("The value of the denominator should not be equal to zero."); 
      }
     } while (terminator != 1);
  }
}
