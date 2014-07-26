import java.util.*;
import javax.swing.JOptionPane;

 public class Arithmetic {
   public static void main(String [] args) {

     while(true)
     {
     int x = (int) (Math.random()*10) ;
     int y = (int) (Math.random()*10) ;

     //Scanner keyboard = new Scanner (System.in);
     //System.out.print( x + "*" + y + " = ");
     //int z = keyboard.nextInt();

     
     String msg = x + "*" + y + " = " + "  (-1 to exit)";
     String inputStr = JOptionPane.showInputDialog(msg, "0");

     /** Handles null input */
     if (inputStr == null)
        return; 

     int z = Integer.parseInt(inputStr); 
     if (z == -1)
         break;
     
     if ( z == x*y) {
         //System.out.println("Congratulations!") ;
         JOptionPane.showMessageDialog( null, "Correct. Congratulations!");
     } else {
        //System.out.println("You need more practice") ;
        JOptionPane.showMessageDialog( null, "Wrong. You need more practice");
     }//endElse

    }//endWhile
   }//endMain
}
