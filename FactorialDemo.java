/**
* Compute 1 + 2 + ... + 100
* @author mkc
*/

import java.util.Scanner;

class FactorialDemo{

  public static void main(String[] arguments){
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter a number > 0: ");
    int n = keyboard.nextInt();

    int product = 1;
    for(int i = 1; i <= n; i++)
        product *= i;
    System.out.println("The factorial of " + n +" is equal to " + product +".");
  }
}
