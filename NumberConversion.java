/** 
Program to convert decimal to binary, octal, and hexadecimal number
@author mkc
*/

import javax.swing.JOptionPane;


public class NumberConversion{

   private static String outputStr;
         
   public static void main(String[] arguments) {
     int number;    

     while(true){
        number = getDecimal();
        computeConversions(number);
        displayOutput();  
        
        /// Terminate if decimal is 0
        if (number == 0) break;       
     }   
    System.exit(0);                                     	
  }//ENDMAIN




   /** Get decimal number. */
   private static int getDecimal(){
       String decimalString =JOptionPane.showInputDialog ("Enter a decimal number(0 to quit): ");
       return Integer.parseInt(decimalString); 
   } 

   /** Compute binary, octal, and hexadecimal. */
   private static void computeConversions(int num){ 

         if(num >= 0) {

             outputStr = "Binary: " + Integer.toBinaryString(num) + "\n" +
                         "Octal: " + Integer.toOctalString(num) + "\n" +
                         "Hexadecimal: " + Integer.toHexString(num).toUpperCase() + "\n";              
         
              
        } else {
                     outputStr = "Binary: -" + Integer.toBinaryString((-num)) + "\n" +
                         "Octal: -" + Integer.toOctalString((-num)) + "\n" +
                         "Hexadecimal: -" + Integer.toHexString((-num)).toUpperCase() + "\n";              
        }
   }
 
  /** Display output. */ 
  private static void displayOutput(){
       JOptionPane.showMessageDialog(null, outputStr, "Number Conversion",              
                                JOptionPane.INFORMATION_MESSAGE);  
  }

}//ENDCLASS

