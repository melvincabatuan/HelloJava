import java.util.*;

class FormatterDemo{
 
    public static void main(String[] args){ 
      try{
        final Formatter myFile = new Formatter("thesis.txt");
        System.out.println("File created.");
      }
     /*
     * Note: Formatter throws an exception if the 
     * error is NOT handled.
     * unreported exception FileNotFoundException; 
     * must be caught or declared to be thrown
     */

      catch(Exception e){
        System.out.println("ERROR");
      }
    }
}
