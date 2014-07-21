import java.util.*;

public class MenuLoop
{
   public static void main(String[] args)
   {
    int ch = 0;
    while (ch != 'C' && ch != 'c')
    {
    /* Write menu here. */
    System.out.println("Press C or c to continue.");
    ch = System.in.readLine();
    }
   }
}
