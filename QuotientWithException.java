import java.util.Scanner;


public class QuotientWithException {
 
  public static int quotient(int number1, int number2) {
       if (number2 == 0)
          throw new ArithmeticException("Divisor cannot be zero");
    return number1 / number2;
  }


   public static int quotientWithIf(int number1, int number2) {
       if (number2 == 0){
          System.out.println("Divisor cannot be zero");
          System.exit(1); // You are forced to exit, or else encounter the ArithmeticException
       }
    return number1 / number2;
  }
/*
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at QuotientWithException.quotientWithIf(QuotientWithException.java:17)
	at QuotientWithException.main(QuotientWithException.java:36)

*/




 public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter two integers: ");
      int number1 = input.nextInt();
      int number2 = input.nextInt();

      try {
          int result = quotient(number1, number2);
          System.out.println(number1 + " / " + number2 + " is " + result);
      }
      catch (ArithmeticException e) {
          System.out.println("Exception: an integer cannot be divided by zero ");
      }
     System.out.println("Execution continues ...");

     int result = quotientWithIf(number1, number2);
     System.out.println("Execution halts ...");
     }
}
