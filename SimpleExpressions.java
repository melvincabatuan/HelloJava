public class SimpleExpressions
{
   public static void main(String[] args)
  {
   int counter = 1;
   double temperature = 37.6;  
   String firstName = "Melvin";
   int[] ages = { 19, 18, 25, 28 };
   char gradeLetters[] = { 'A', 'B', 'C', 'D', 'F' };
   float[][] matrix = { { 1.0F, 2.0F, 3.0F }, { 4.0F, 5.0F, 6.0F }};
   int x = 1, y[] = { 1, 2, 3 }, z = 3;
   double p = 3.14159;

   System.out.println("counter = " + counter);
   System.out.println("temperature = " + temperature); 
   System.out.println("ages.length = " + ages.length);
  // System.out.println("ages = " + ages); //Prints an address
   System.out.println("gradeLetters.length = " + gradeLetters.length);
  // System.out.println("gradeLetters = " + gradeLetters); //Prints an address  
   System.out.println("matrix.length = " + matrix.length); // rows
   System.out.println("matrix[0].length = " + matrix[0].length); //cols
  // System.out.println("matrix = " + matrix); //Prints an address
   System.out.println("x = " + x);
   System.out.println("y.length = " + y.length);
   System.out.println("z = " + z);
   System.out.println("p = " + p);
   }
}
