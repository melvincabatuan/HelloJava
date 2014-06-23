/**
* A Simple Number Guessing Game
* @author mkc
*/
import java.util.*;

public class GuessNumber{
        public static void main( String [] args) {
           final int GUESS_LIMIT = 3;
           int number = (int)(Math.random()*10) + 1;
           Scanner keyboard = new Scanner(System.in);

           for (int numTries = 0; numTries < GUESS_LIMIT; numTries++) {
               System.out.println("Enter your guess [1 to 10]: ");
               int guess = keyboard.nextInt();

               /** If guess is correct */
               if ( guess == number) {
                   System.out.println("Congratulations! You got it!");
               return;
               }

               /** If guess is larger than the number */
               if ( guess > number) {
               System.out.println("Go lower");
               } 

               /** If guess is lower than the number */
               else {
               System.out.println( "Go higher" );
               }
           }// ENDFOR
        
          System.out.println ( "Sorry... You ran out of guesses!" ) ;
          System.out.println ( "My number was: " + number) ;
      }//ENDMAIN
 }//ENDCLASS
