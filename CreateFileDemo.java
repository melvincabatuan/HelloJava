import java.io.*;
import java.lang.*;
import java.util.*;

class CreateFileDemo{ 

      private Formatter f;

      public void openFile(){
      System.out.println("Opening file ... ");
        try{
           f = new Formatter("thesis.txt");
           System.out.println("File created.");
        }
        catch(Exception e){
           System.out.println("ERROR");
        }
      }

      public void addRecord(){
         System.out.println("Adding record ... ");
         f.format("%s%s%s%s", "Author: ", "Melvin ", "Kong ","Cabatuan"); 
      }

      public void closeFile(){
         System.out.println("Closing file ... ");
         f.close();
      }

}
