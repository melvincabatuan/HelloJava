import java.util.*;

  public class Diamond2 {
     public static void printStrings( String s , int n) {
          for ( int i = 0; i < n ; i++) {
              System.out.print(s);
          }
     }

   public static void printLine ( int numSpaces , int numStars ) {
      printStrings(" ", numSpaces );
      printStrings("* " , numStars );
      System.out.println ( "" ) ;
   }

  public static void main( String [] args ) {
     Scanner keyboard = new Scanner ( System.in );
     System.out.print("Enter size of diamond: ");
     int size = keyboard.nextInt() ;
     for (int numStars = 1 , numSpaces = size - 1 ; numSpaces >= 0; numSpaces -= 2 , numStars += 2) {
          printLine ( numSpaces , numStars ) ;
     }
     for ( int numStars = size - 2 , numSpaces = 2 ; numStars >= 0; numSpaces += 2 , numStars -= 2) {
          printLine ( numSpaces , numStars ) ;
     }
  }
}


/*
$ javac Diamond2.java 
$ java Diamond2
Enter size of diamond: 4
   * 
 * * * 
  * * 
    
$ java Diamond2
Enter size of diamond: 13
            * 
          * * * 
        * * * * * 
      * * * * * * * 
    * * * * * * * * * 
  * * * * * * * * * * * 
* * * * * * * * * * * * * 
  * * * * * * * * * * * 
    * * * * * * * * * 
      * * * * * * * 
        * * * * * 
          * * * 
            * 
*/
