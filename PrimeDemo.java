/**
* Determine if the number n is prime.
* @author mkc
*/

import java.util.Scanner;

class PrimeDemo{

  public static void main(String[] arguments){
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter an integer > 2: ");
    int n = keyboard.nextInt();

    int counter = 0;
    for(int d = 2; d <= n/2; d++){
        System.out.println( n + " % " + d + " = " + n % d);
        if(n % d == 0)
           counter++;
    }
    if(counter != 0)
         System.out.println("Number " + n +" is NOT prime.");
    else
         System.out.println("Number " + n +" is a prime number.");    
  }
}
