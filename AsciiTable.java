/**
* A Simple Java Program to display ASCII Table
* @author mkc
*/
public class AsciiTable
{
    public static void main(String[] args)
   {

   /** Local variables */
   char hexLetter; // For table header
   char ascCode = 0x20; // First ASCII code

   /** Counters for rows and columns */
   int row = 2;
   int column;
   System.out.print("\n\n");
   System.out.print("           ");

   System.out.println("A S C I I   C H A R A C T E R   T A B L E");
   System.out.print("                           ");
   System.out.println("0x20 to 0xff");
   System.out.print("   \n    ");
 
   /** Display column heads for numbers 0 to F hexadecimal */
   for(hexLetter = '0'; hexLetter <= '9'; hexLetter ++)
       System.out.print("   " + hexLetter);

   for(hexLetter = 'A'; hexLetter <= 'F'; hexLetter ++)
       System.out.print("   " + hexLetter);

   System.out.println("\n");
   hexLetter = 'A';

   while (ascCode <= 0xFF)
   {
       if( row < 10 ){            
            System.out.print("   " + row);
            row ++;
       }
       else {
            System.out.print("   " + hexLetter);
            hexLetter++;
       }

       for (column = 0; column < 16; column ++)
       {
           System.out.print("   " + ascCode);
           ascCode ++;
       }
       System.out.println("\n");
       
   } //ENDWHILE
 }//ENDMAIN
}//ENDCLASS

