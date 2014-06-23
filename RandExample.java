import java.math.*;

public class RandExample{
    public static void main (String[] arguments){ 
        for (int row = 1; row < 20; row += 2)
        {
                for (int col = 0; col < 19 - row / 2; col++)
                     System.out.print(" ");

                for (int col = 0; col < row; col++)
                  System.out.print((int)(Math.random()*10));
                System.out.println();
      }
        for (int row = 21; row > 0; row -= 2)
        {
                for (int col = 0; col < 19 - row / 2; col++)
                     System.out.print(" ");
                for (int col = 0; col < row; col++)
                  System.out.print((int)(Math.random()*10));
                System.out.println();
      }
  }// ENDMAIN
}// ENDCLASS

 

 
 
