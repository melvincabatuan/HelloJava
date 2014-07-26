import java.io.*;
import java.util.*;

class ReadFileDemo{ 

      private Scanner s;

      public void openFile(){
      System.out.println("Opening file ... ");
          try{ 
              s = new Scanner(new File("thesis.txt"));
          }
          catch(Exception e){
              System.out.println("File NOT Found!"); 
          }
      }

      public void readFile(){
      System.out.println("Reading file ... ");
          while(s.hasNext()){
             String first = s.next();
             String second = s.next();
             String third = s.next();
             String fourth = s.next();
              
             System.out.printf(" %s %s %s %s \n",first, second, third, fourth);
          }
      }

      public void closeFile(){
         System.out.println("Closing file ... ");
         s.close();
      }

}
