/**
   Provides the length of input arguments.
   @author Melvin Cabatuan
*/

public class WordCount
{
/**
   Application entry point.
   @param args array of command-line arguments.
*/

public static void main(String[] args)
 {
   System.out.println("Passed arguments:");
   for (int i = 0; i < args.length; i++)
        System.out.println(args[i]);
   System.out.println("The word count is " + args.length);
 }
}
