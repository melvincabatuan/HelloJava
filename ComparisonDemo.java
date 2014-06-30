public class ComparisonDemo
{
   public static void main(String[] args)
   {
      System.out.println("Which one of the following declarations of the variable" +
                 "\n i will compile without errors and print true?");

      int i = 012; // output: true
      //int i = 10.0f; // error: possible loss of precision
      //int i = 10L; // error: possible loss of precision
      //int i = 10.0; // error: possible loss of precision

      if(i == 10.0)
         System.out.println("true");
   }
}
