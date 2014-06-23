/**
* A Simple Menu Program
* @author mkc
*/
import java.util.*;

public class MenuExample
{
    public static void main(String[] arguments)
    {
    /** Input reader declaration */
    Scanner keyboard = new Scanner(System.in);

    /** Local variables */
    int choice;
    double celsius, fahrenheit;

    /** Display menu graphics */
    System.out.println("============================================");
    System.out.println("| MENU SELECTION OF TEMPERATURE CONVERSION |");
    System.out.println("============================================");
    System.out.println("| Options: |");
    System.out.println("| 1. Degrees Celsius to Fahrenheit |");
    System.out.println("| 2. Degrees Fahrenheit to Celsius |");
    System.out.println("| 3. Exit |");
    System.out.println("============================================");

    choice = keyboard.nextInt();

    /** Switch construct */
    switch(choice)
    {

    /** Option 1 */
    case 1:
    System.out.println("Degrees Celsius to Fahrenheit Conversion selected!");
    System.out.println("Please Input the Temperature in Degrees Celsius:");
    celsius = keyboard.nextDouble();
    fahrenheit = celsius * (9.0 / 5.0) + 32;
    System.out.println("The Temperature in Degrees Fahrenheit is " + fahrenheit);
    break;

    /** Option 2 */
    case 2:
    System.out.println("Degrees Fahrenheit to Celsius selected");
    System.out.println("Please Input the Temperature in Degrees Fahrenheit:");
    fahrenheit = keyboard.nextDouble();
    celsius = (fahrenheit - 32) * 5.0 / 9.0;
    System.out.println("The Temperature in Degrees Celsius is " + celsius);
    break;

    /** Option 3 */
    case 3:
    System.out.println("Exit selected... Goodbye!");
    break;

    /** Invalid Option */   
    default:
    System.out.println("Invalid selection");
    }
 }//ENDMAIN
}//ENDCLASS
