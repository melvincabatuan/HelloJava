import java.util.Scanner;

public class OutputGrade
{
public static void main(String[] args)
{
    
    String grade = "0.0";  
    Scanner user_input = new Scanner(System.in);

    System.out.println("Input your test mark: ");
    int testMark = user_input.nextInt();

    if (testMark >= 95)
    {
       grade = "4.0";
       System.out.println("You aced the test. Your grade is " + grade);
    }
    else
    if (testMark >= 90)
    {
       grade = "3.5";
       System.out.println("You did very well on this test. Your grade is " + grade);
     }
     else
     if (testMark >= 85)
     {
       grade = "3.0";
       System.out.println("Not bad. Your grade is " + grade);
      }
       else
     if (testMark >= 80)
     {
       grade = "2.5";
       System.out.println("Not bad, but you need to study more for future tests. Your grade is " + grade);
      }
      else
      if (testMark >= 75)
      {
       grade = "2.0";
       System.out.println("Your test result suggests that you need a tutor. Your grade is " + grade);
       }
      else
      if (testMark >= 70)
      {
       grade = "1.5";
       System.out.println("Your test result suggests that you need a tutor. Your grade is " + grade);
       }
        else
      if (testMark >= 65)
      {
       grade = "1.0";
       System.out.println("Your test result is pathetic; you need summer school. Your grade is " + grade);
       }
       else
       {
       grade = "0.0";
       System.out.println("Your test result is pathetic; you need to rethink your course. Your grade is " + grade);
       }
   } //ENDMAIN
}//ENDCLASS
