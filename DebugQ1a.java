import java.util.Scanner;

public class DebugQ1a
{

  public static void main(String[] args)
  {
     String name;
     int idNumber;

     Scanner keyboard = new Scanner(System.in);
     System.out.print("Please enter your I.D. Number: ");
     idNumber = keyboard.nextInt();
     //keyboard.nextLine();
     System.out.print("Please enter your name: ");
     name = keyboard.nextString();
     System.out.println("Your name is " + name +
           " and your I.D. number is " + idNumber + ".");
  }
}
