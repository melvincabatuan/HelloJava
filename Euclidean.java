import java.util.Scanner;

/** Find GCD for integers m and n */
 public class Euclidean{
 
 public static int gcd(int m, int n) {
 if (m % n == 0)
 return n;
 else
 return gcd(n, m % n);
 }

 /** Main method */
 public static void main(String[] args) {
 
 Scanner input = new Scanner(System.in);

 // Prompt the user to enter two integers
 System.out.print("Enter first integer: ");
 int m = input.nextInt();
 System.out.print("Enter second integer: ");
 int n = input.nextInt();

 System.out.println("The greatest common divisor for " + m + " and " + n + " is " + gcd(m, n) + "." );
 }
}
